# 超市进存销系统
## 代码文件组成

- supermarket
  - .idea：
  - .mvn：
  - md：项目开发文档
  - sql：MySQL数据库文件
  - src：核心代码文件
    - java：存放java源代码
    - resources：存放java配置文件
    - test：存放测试文件
  - target：
  - mvnw：
  - mvnw.cmd：
  - pom.xml：项目配置文档，内含项目依赖
  - supermarket.iml：
  - supemarket.sql：
- External Libraries：外部拓展库
- Scratches and Consoles：编辑环境配置



## 主要技术配置：

Spring Boot + Vue + Elementui + MySQL8.0



## 各模块说明：

#### 登录模块

**技术栈：spring boot, spring security, mybatis, mysql, vue, element-ui,axios**

- 前端：绘制界面Login.vue，并封装axios，在plugins/api.js，进行统一的错误处理，然后通过axios调用后台接口获得数据，登录成功之后需要获得用户名和token。

- 后端：统一返回JSON数据格式，在ResultDTO.java，数据格式为{status：''，msg：'', data：''}。

  e.g：在登录模块里需要封装username和token，作为一个对象，保存到data，此时Json为{status:'200', msg:'登录成功', data:'{username,token}'}提供给前端。

**相关类说明：**

- MyCrosConfig：解决跨域问题。
- MyPasswordEncoder和MyWebSecurityConfig：用来做用户密码的加密。
- ResultDTO：后台统一返回的结果集

**application.yml说明：**

- 端口：8080

- 后端用localhost:8080进行测试，前端的调用url封装在api.js里的baseURL

- 由于配置文件的数据比较敏感，所以加密了，需要在本机配置环境变量：

  变量名：ENCRYPTOR_PASSWORD，

  变量值：EbfYkitulv73I2p0mXI50JMXoaxZTKJ7

**部署运行：**

1. 搭建好基本的环境，然后在本地创建git仓库，clone下来。
2. 运行命令：前端项目npm run serve，后端可以先打包再运行，如果电脑比较卡的话，打包命令为mvn clean package, 运行命令为java -jar xxx.jar。
3. 数据库运用了阿里云服务的Druid数据源。



#### 销售模块

- 销售
- 查看销售记录(分页)
- 查看具体销售记录对应的销售项列表


##### 销售业务
**前端：**

- 页面展示销售商品的部分信息(商品编号、商品名称、商品单价),需要分页展示(**不展示已停产或已经断货的商品，即gds_status=0的商品**)，并且支持通过商品编号搜索商品。
- 每条商品记录最后提供一个数目框和`+/-`按钮，供员工计算本次交易某商品的数目
- 员工需要输入本次处理交易的员工编号
- 对一次交易所涉及的所有商品进行完+操作后，把所有数目不为0的商品项打包成`SellItem`数组，提交给后端
- 请求url：/sell/addOrder/员工编号

**后端：**

```java
/**
* 提交订单（销售记录）
* @param sellItem 销售项集合
* @param sfId 员工编号
* @return 提示消息
*/
@PostMapping(value = "/addOrder/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
public ResultDTO addOrder(@RequestBody SellItem[] sellItem, @PathVariable("id") int sfId) {
    return sellService.sell(sellItem, sfId);
}
```
**注意要在数组参数前加`@RequestBody`注解**

sell()就是销售业务对应的方法，传入销售项数组和员工编号后，在数据库生成**销售记录**，销售记录对应的**销售项集**以及**修改商品库存**。

##### 查看销售记录
后端接受请求:/sell/record/页码/页面大小
```java
/**
* 分页查询销售记录
* @param pageNo 页码
* @param size 页面大小
* @return 销售记录列表
*/
@GetMapping("/record/{pageNo}/{size}")
public ResultDTO getSellRecords(@PathVariable("pageNo") int pageNo, @PathVariable("size") int size) {
    return sellService.showSellRecordList(pageNo, size);
}
```
分页主要的类：PageDTO,用来指导分页
```java
public class PageDTO<T> {

    /**
     * 数据记录集合
     */
    private List<T> data;
    /**
     * 总页码
     */
    Integer pagesNum;
    /**
     * 记录总条数
     */
    private Integer recordsNum;
    
    /**
     * 偏移量
     */
    private Integer start;
    /**
     * 页面大小
     */
    private Integer pageSize;
}
```
后台根据start和pageSize就可以使用sql语句`select * from xx limit start,pageSize`进行分页查询了
前端根据data、pagesNum、recordsNum可以显示分页的列表，总页数

**如何使用：**

- 在需要进行分页查询的业务中使用`pageDTO`
- 需要的参数：页码，页面大小，总记录条数
  - 页码和页面大小是从前端传过来的
  - 总记录条数是xxxMapper.countNum()算出来的
- 得到三个参数后，利用pageDTO的构造器，new PageDTO(页面大小，总记录条数，页码)，获得一个PageDTO，利用生成的pageDTO可以获得分页查询所需的参数：偏移量start=pageDTO.getStart()，和分页大小size=pageDTO.getPageSize()
- 进行完分页查询后获得的列表，用pageDTO.setData(xxx)方法存放到PageDTO中，这样，前端就能用PageDTO获取分页的列表，总页码和总记录条数进行分页展示了



#### 进货模块

##### 进货业务

**前端：**

- 进入进货界面，正确填写商品编号、选填供货商编号、填写进货单价、进货数量和员工编号后，点击提交进货表即可在数据库中新增进货记录和修改商品库存。
- 其中，商品名称和供货商名称会根据填入的商品编号和供货商编号自动查找数据库表并填入。
- 点击“重置”，界面刷新。
- 另外，一次进货的数量设定不可少于10个。

**后端：**

后端接受请求：/allPurRecord/调用controller下的PurchaseController下的addPurchaseRecord方法，然后service下的PurchaseService.purchase被调用，根据service下的业务逻辑，调用不同mapper接口利用resources.mybatis.mapper下的xml文件进行数据库操作，与数据库进行连接，然后利用dto文件中的传输类传输数据到前端。

所有业务逻辑的函数调用流程都一样，后面不在赘述。

`controller：`

```java
/** 
* 进货，新增进货记录 
* @param purchaseRecord 一条进货记录 
* @return 提示消息 
*/
@PostMapping(value = "/addPurchase", consumes = MediaType.APPLICATION_JSON_VALUE)
public String addPurchaseRecord(@RequestBody PurchaseRecord purchaseRecord) {   
    return purService.purchase(purchaseRecord);
}
```

`service：`

```java
    /**
     * 进货处理，添加进货记录，修改商品库存
     * @param purchaseRecord 一条进货记录
     * @return 提示信息
     */
    public String purchase(PurchaseRecord purchaseRecord) {
        System.out.println(purchaseRecord);
        //不能提交空的进货项
        if(purchaseRecord == null) {
            return "请添加进货记录";
        }
        Goods goods = goodsMapper.selectGoodsById(purchaseRecord.getGoodsId());
        if (goods == null){
            return "该商品不存在，请先录入该商品。";
        }
        //前端传过来的supplierId, staffId, goodsId, goodsNum, goodsPrice
        purchaseRecord.setPurchaseDate(new Date());
        //新增一条进货记录
        int res = purchaseMapper.addPurRecord (purchaseRecord);
        System.out.println(res);
        //修改商品库存信息
        goods.setAmount(goods.getAmount()+purchaseRecord.getAmount());
        //更新数据库记录
        int updated = goodsMapper.updateGoods(goods);
        if (updated == 1) {
            return "进货成功";
        }
        return "操作失败";
    }
```



##### 查看进货记录

**前端：**

- 点击进入进货历史界面，系统会自动搜索展示进货历史。
- 进货历史的信息有：进货编号、商品名称、进货单价、进货数量、进货日期、供应商、进货员工编号。
- 可以根据自己需求设置每页进货记录数量。
- 可以根据商品名称查找进货历史，分析商品的进货情况。

**后端：**

`controller：`

```java
/**
     * 分页展示进货记录
     * @return 进货记录列表，List存储
     */
    @GetMapping("/allPurRecord")
    public PageDTO<PurchaseDTO> getPurRecordsByPage(HttpServletRequest request) {
        int page = Integer.parseInt(request.getParameter("pageNo"));
        int size = Integer.parseInt(request.getParameter("size"));
        return purService.showPurRecordByPage(page, size, request.getParameter("name"));
    }

```

`service：`

```java
    /**
     * 分页展示进货记录
     * @return 进货记录列表
     */
    public PageDTO<PurchaseDTO> showPurRecordByPage(int page, int size,String goodsName) {
        List<Integer> goodsIdList = goodsMapper.selectIdByName(goodsName);
        //如果不存在该名字的商品
        if(goodsIdList.size() == 0) {
            return null;
        }
        
        
          //获取进货总记录条数
        int total = purchaseMapper.getCount(goodsIdList);
        //根据page,size,total获取偏移量
        PageDTO<PurchaseDTO> pageDTO = new PageDTO<>(size, total, page);
        //获取记录集合，封装
        List<PurchaseRecord> allPurRecord = purchaseMapper.selectPurRecordByPage(pageDTO.getStart(), pageDTO.getPageSize(),goodsIdList);
        //将数据库进货记录映射到 前端展示的记录
        List<PurchaseDTO> data = new ArrayList<>(allPurRecord.size());
        for (PurchaseRecord record : allPurRecord) {
            data.add(new PurchaseDTO(record.getPurchaseId(),
                    goodsMapper.selectNameById(record.getGoodsId()),
                    record.getPrice(),
                    record.getAmount(),
                    record.getPurchaseDate(),
                    supplierMapper.selectSupplierId(record.getSupplierId()).getSpName(),
                    record.getStaffId()
            ));
        }
```



#### 商品管理

##### 库存管理

**前端：**

- 此页面主要展示的是库存不足的商品，即库存数量<50的商品。
- 点击进入商品库存界面，可看到库存不足的商品信息，包括商品编号、商品名称、商品品牌、商品型号、商品种类、商品库存、商品单位。
- 可以根据自己需求设置每页库存不足商品的条数。
- 另外，可以点击导出报表功能，导出库存不足的商品，方便进货。

**后端：**

`controller：`

```java
@RestController
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @GetMapping("/goods/{pageNo}/{size}")
    public ResultDTO findGoodsLess(@PathVariable("pageNo") int pageNo, @PathVariable("size") int size) {
        return goodsService.showGoodsLess(pageNo,size);
    }
}
```

`service：`

```java
    /**
     * 分页查询库存少于50的商品
     * @param pageNo 页码
     * @param size 页面大小
     * @return
     */
    public ResultDTO showGoodsLess(int pageNo, int size) {
        int count = goodsMapper.countGoodsLess();
        PageDTO<Goods> pageDTO = new PageDTO<>(size, count, pageNo);
        List<Goods> goods = goodsMapper.selectGoodsLessByPage(pageDTO.getStart(), pageDTO.getPageSize());
        pageDTO.setData(goods);
        return ResultDTO.success("库存少于50的商品",pageDTO);
    }
```



#### 员工管理

**前端：**

- 点击进入商品库存界面，可看到员工的信息，此模块只出现在管理员账号登录的系统，员工无法查看员工信息。
- 返回的数据有：姓名、性别、身份证号、电话号码、电子邮箱、联系地址、任职状态等。
- 可以根据自己需求设置每页查看的员工信息条数。

**后端：**

与商品信息展示接近，此处不再赘述。

#### 供应商管理

**前端：**

- 点击进入商品库存界面，可看到供应商的信息，包括供应商编号、供应商名称、地址、联系方式、描述。
- 可以根据自己需求设置每页供应商信息的条数。

**后端：**

与商品信息展示接近，此处不再赘述。



前端项目运行前需要下载node.js
----------------------------------------------------

数据库文件的使用：具体操作是在本地 MySQL中创建一个空的数据库，然后运行SQL脚本文件，并修改项目中关于数据库的配置（resources 目录下的 application.yml文件中），由于信息保密的需要，配置文件经过加密处理了，如果不需要的可以去掉pom.xml中相关的依赖，并讲配置文件中的相关部分删除。

后端需要搭建好基本的java运行环境
--------------------------------------------------------------------------------------------------------------

## 项目运行访问

分前后端，打开两个命令行，

- 后端Supermarket项目直接在idea运行

- 前端Supermkvue在命令行2中进入该前端源码文件夹，运行前端代码：

  ```bash
  第一步安装依赖：npm install
  第二步直接运行：npm run serve
  ```

- 浏览器访问路径：localhost:8080

- 登录测试账号：用户名：ceshi，密码：123456