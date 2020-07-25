CREATE TABLE `goods` (
  `gds_id` INT(10) NOT NULL AUTO_INCREMENT 	COMMENT '商品编号',
  `gds_name` VARCHAR(20) NOT NULL 		COMMENT '商品名称',
  `brand` VARCHAR(20) DEFAULT NULL 		COMMENT '品牌',
  `modle` VARCHAR(20) DEFAULT NULL 		COMMENT '型号',
  `category` VARCHAR(20) DEFAULT NULL 		COMMENT '种类',
  `price` FLOAT NOT NULL 			COMMENT '销售单价',
  `amount` INT(10) DEFAULT NULL 		COMMENT '库存数量',
  `gds_state` CHAR(1) DEFAULT NULL 		COMMENT '状态(1正常/0停产)',
  `unit` VARCHAR(6)				COMMENT '单位',
  PRIMARY KEY (`gds_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='商品信息';

CREATE TABLE `supplier` (
  `sp_id` INT(10) NOT NULL AUTO_INCREMENT 	COMMENT '供货商编号',
  `sp_name` VARCHAR (20) NOT NULL 		COMMENT '供货商名称',
  `location` CHAR(25) DEFAULT NULL 		COMMENT '所在地',
  `sp_tel` VARCHAR (11) NOT NULL 		COMMENT '联系方式',
  `description` CHAR(50) DEFAULT NULL 		COMMENT '备注',
  PRIMARY KEY (`sp_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 	COMMENT='供货商信息';

CREATE TABLE `staff` (
  `sf_id` INT(10) NOT NULL AUTO_INCREMENT COMMENT '员工编号',
  `sf_yname` VARCHAR(20) NOT NULL COMMENT '员工姓名',
  `indentity` CHAR(18) NOT NULL COMMENT '身份证号',
  `sf_tel` VARCHAR(11) DEFAULT NULL COMMENT '联系方式',
  `sex` CHAR(2) DEFAULT NULL COMMENT '性别',
  `password` VARCHAR(30) DEFAULT '1234' COMMENT '密码',
  `sf_status` CHAR(1) DEFAULT NULL COMMENT '状态(1在任/0离职)',
  PRIMARY KEY (`sf_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='员工表';

CREATE TABLE `purchase` (
  `p_id` INT(10) NOT NULL AUTO_INCREMENT COMMENT '进货编号',
  `sp_id` INT(10) NOT NULL COMMENT '供货商编号',
  `sf_id` INT(10) NOT NULL COMMENT '员工号',
  `p_data` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '进货日期',
  PRIMARY KEY (`p_id`),
  KEY `purchase_and_supplier` (`sp_id`),
  KEY `purchase_and_staff` (`sf_id`),
  CONSTRAINT `purchase_and_supplier` FOREIGN KEY (`sp_id`) REFERENCES `supplier` (`sp_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `purchase_and_staff` FOREIGN KEY (`sf_id`) REFERENCES `staff` (`sf_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='进货表';


CREATE TABLE `sell` (
  `sell_id` INT(10) NOT NULL AUTO_INCREMENT COMMENT '销售编号',
  `sf_id` INT(10) NOT NULL COMMENT '员工编号',
  `sell_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '销售日期',
  PRIMARY KEY (`sell_id`),
  KEY `sell_and_staff` (`sf_id`),
  CONSTRAINT `sell_and_staff` FOREIGN KEY (`sf_id`) REFERENCES `staff` (`sf_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='销售表';

CREATE TABLE `sell_record` (
  `sell_id` INT(10) NOT NULL COMMENT '销售编号',
  `gds_id` INT(10) NOT NULL COMMENT '商品编号',
  `price` FLOAT DEFAULT NULL COMMENT '销售单价',
  `amount` INT(5) NOT NULL COMMENT '销售数量',
  PRIMARY KEY (`sell_id`,`gds_id`),
  KEY `销售商品信息关联` (`gds_id`),
  KEY `销售成交编号关联` (`sell_id`),
  CONSTRAINT `销售商品信息关联` FOREIGN KEY (`gds_id`) REFERENCES `goods` (`gds_id`),
  CONSTRAINT `销售成交编号关联` FOREIGN KEY (`sell_id`) REFERENCES `sell` (`sell_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='销售记录';

CREATE TABLE `purchase_record` (
  `p_id` INT(10) NOT NULL COMMENT '进货编号',
  `gds_id` INT(10) NOT NULL COMMENT '商品编号',
  `price` FLOAT DEFAULT NULL COMMENT '进货单价',
  `amount` INT(5) NOT NULL COMMENT '进货数量',
  PRIMARY KEY (`p_id`,`gds_id`),
  KEY `进货商品信息关联` (`gds_id`),
  KEY `进货编号关联` (`p_id`),
  CONSTRAINT `进货商品信息关联` FOREIGN KEY (`gds_id`) REFERENCES `goods` (`gds_id`),
  CONSTRAINT `进货编号关联` FOREIGN KEY (`p_id`) REFERENCES `purchase` (`p_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='进货记录';

CREATE TABLE `admin` (
  `admin_id` INT(10) NOT NULL AUTO_INCREMENT COMMENT '管理员编号',
  `admin_name` VARCHAR(20) NOT NULL COMMENT '管理员姓名',
  `admin_password` VARCHAR(30) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`admin_id`),
  UNIQUE KEY `user_username_uindex` (`admin_name`)
) ENGINE=INNODB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='管理员';

