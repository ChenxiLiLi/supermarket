# supermarket
## 名词解释
- 销售记录
  - 销售编号
  - 员工编号
  - 销售时间
- 销售项
  - 销售编号
  - 商品编号
  - 商品单价
  - 销售数量


场景：顾客于10：30(**销售时间**)带着一根牙刷(**商品编号1，单价10**)和两支牙膏(**商品编号2，单价15**)来到超市收银台找收银员小生(**员工编号1**)结账。
记本次销售编号为5，那么销售项就有两项，分别为`(5,1,10,1)`和`(5,2,15,2)`，销售记录为`(5,1,10:30)`。




## 销售模块
- 销售

- 查看销售记录(分页)
- 查看具体销售记录对应的销售项列表


### 销售业务
前端：
- 页面展示销售商品的部分信息(商品编号、商品名称、商品单价),需要分页展示(**不展示已停产即gds_status=0的商品**)，并且支持通过商品编号搜索商品。
- 每条商品记录最后提供一个数目框和`+/-`按钮，供员工计算本次交易某商品的数目
- 员工需要输入本次处理交易的员工编号
- 对一次交易所涉及的所有商品进行完+操作后，把所有数目不为0的商品项打包成`SellItem`数组，提交给后端
- 请求url：/sell/addOrder/员工编号

后端：
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

### 查看销售记录
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

如何使用：
- 在需要进行分页查询的业务中使用`pageDTO`
- 需要的参数：页码，页面大小，总记录条数
  - 页码和页面大小是从前端传过来的
  - 总记录条数是xxxMapper.countNum()算出来的
- 得到三个参数后，利用pageDTO的构造器，new PageDTO(页面大小，总记录条数，页码)，获得一个PageDTO，利用生成的pageDTO可以获得分页查询所需的参数：偏移量start=pageDTO.getStart()，和分页大小size=pageDTO.getPageSize()
- 进行完分页查询后获得的列表，用pageDTO.setData(xxx)方法存放到PageDTO中，这样，前端就能用PageDTO获取分页的列表，总页码和总记录条数进行分页展示了






