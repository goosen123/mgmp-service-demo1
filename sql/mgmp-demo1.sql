/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50625
Source Host           : localhost:3306
Source Database       : mgmp-demo1

Target Server Type    : MYSQL
Target Server Version : 50625
File Encoding         : 65001

Date: 2018-07-10 18:47:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` varchar(64) NOT NULL COMMENT '主键',
  `userId` varchar(255) DEFAULT NULL COMMENT '用户ID',
  `userName` varchar(255) DEFAULT NULL COMMENT '用户名称',
  `code` varchar(255) DEFAULT NULL COMMENT '订单号',
  `orderTitle` varchar(255) DEFAULT NULL COMMENT '订单标题',
  `totalCost` double DEFAULT NULL COMMENT '订单总金额',
  `totalVolume` int(11) DEFAULT NULL COMMENT '订单总量',
  `orderStatus` int(11) DEFAULT NULL COMMENT '商品订单状态：0待付款 1待发货 2待收货 3待评价 4退款中 5已完成 6已取消 7已退款 8拒绝退款',
  `isPay` int(11) DEFAULT NULL COMMENT '是否支付了：0未支付 1已支付',
  `payWay` int(11) DEFAULT NULL COMMENT '支付方式 1支付宝 2微信 3银联 4余额',
  `payWayDetail` int(11) DEFAULT NULL COMMENT '支付方式详细 0余额支付  1微信app支付  2微信公众号支付 3微信小程序支付 4微信扫码支付 5微信刷卡支付 6H5支付',
  `orderRemark` varchar(255) DEFAULT NULL COMMENT '订单备注',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('00adb475cf5d459eab09b9074bd2ff59', '861aa2703f1a4f04bb448e3ac07d2ad8', '普通郭靖', 'O2018071000009', null, '75', '3', '0', '0', null, null, '小心轻放', '2018-07-10 18:42:31', '2018-07-10 18:42:31');
INSERT INTO `orders` VALUES ('154c5bb373304bd58c52f2276f136d31', '861aa2703f1a4f04bb448e3ac07d2ad8', '普通郭靖', 'O2018071000005', null, '75', '3', '0', '0', null, null, '小心轻放', '2018-07-10 14:48:22', '2018-07-10 14:48:22');
INSERT INTO `orders` VALUES ('172db51781764a538f06be03182e73a6', '861aa2703f1a4f04bb448e3ac07d2ad8', '普通郭靖', 'O2018071000001', null, '75', '3', '0', '0', null, null, '小心轻放', '2018-07-10 14:44:21', '2018-07-10 14:44:21');
INSERT INTO `orders` VALUES ('3297013118cc47649fe49fcc7c6f30c7', '861aa2703f1a4f04bb448e3ac07d2ad8', '普通郭靖', 'O2018071000007', null, '75', '3', '0', '0', null, null, '小心轻放', '2018-07-10 18:21:39', '2018-07-10 18:21:39');
INSERT INTO `orders` VALUES ('5e3bfd5c421d4c5eafc59dac32c28918', '861aa2703f1a4f04bb448e3ac07d2ad8', '普通郭靖', 'O2018071000002', null, '75', '3', '0', '0', null, null, '小心轻放', '2018-07-10 14:44:57', '2018-07-10 14:44:57');
INSERT INTO `orders` VALUES ('a907fdc465c44318ba7a0b6f55ec6b33', '861aa2703f1a4f04bb448e3ac07d2ad8', '普通郭靖', 'O2018071000003', null, '75', '3', '0', '0', null, null, '小心轻放', '2018-07-10 14:45:18', '2018-07-10 14:45:18');
INSERT INTO `orders` VALUES ('bf415b8674e54d60be83d1b9b5041cf5', '861aa2703f1a4f04bb448e3ac07d2ad8', '普通郭靖', 'O2018071000004', null, '75', '3', '0', '0', null, null, '小心轻放', '2018-07-10 14:48:09', '2018-07-10 14:48:09');
INSERT INTO `orders` VALUES ('c0049147b74c4c5cb91288f59c6fe190', '861aa2703f1a4f04bb448e3ac07d2ad8', '普通郭靖', 'O2018071000008', null, '75', '3', '0', '0', null, null, '小心轻放', '2018-07-10 18:22:44', '2018-07-10 18:22:44');
INSERT INTO `orders` VALUES ('f24731a04a504a46b108d0bcc6e6de8c', '861aa2703f1a4f04bb448e3ac07d2ad8', '普通郭靖', 'O2018071000006', null, '75', '3', '0', '0', null, null, '小心轻放', '2018-07-10 14:50:45', '2018-07-10 14:50:45');

-- ----------------------------
-- Table structure for `orders_product`
-- ----------------------------
DROP TABLE IF EXISTS `orders_product`;
CREATE TABLE `orders_product` (
  `id` varchar(64) NOT NULL COMMENT '主键',
  `orderId` varchar(255) DEFAULT NULL COMMENT '订单ID',
  `productId` varchar(255) DEFAULT NULL COMMENT '商品ID',
  `code` varchar(255) DEFAULT NULL COMMENT '产品编码',
  `coverPic` varchar(255) DEFAULT NULL COMMENT '封面',
  `cyclePic` longtext COMMENT '轮播图',
  `productTitle` varchar(255) DEFAULT NULL COMMENT '标题',
  `productBrief` varchar(255) DEFAULT NULL COMMENT '产品简介',
  `productDesc` longtext COMMENT '产品详情介绍',
  `productAttrId` varchar(255) DEFAULT NULL COMMENT '商品属性ID',
  `attrName` varchar(255) DEFAULT NULL COMMENT '属性名称',
  `attrPic` varchar(255) DEFAULT NULL COMMENT '属性封面',
  `attrBrief` varchar(255) DEFAULT NULL COMMENT '属性简介',
  `originalPrice` double DEFAULT NULL COMMENT '原价',
  `salePrice` double DEFAULT NULL COMMENT '售价',
  `itemVolume` int(11) DEFAULT NULL COMMENT '条目数量',
  `itemCost` double DEFAULT NULL COMMENT '条目金额',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单商品表';

-- ----------------------------
-- Records of orders_product
-- ----------------------------
INSERT INTO `orders_product` VALUES ('219d27a46ceb437e993671b9eef50b7d', '154c5bb373304bd58c52f2276f136d31', '5c8432d7b7674301a961d1803538e364', 'P002', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '时尚男装2', '商品简介2', null, '8c7f274a0ede4ccd82fe4e232b28f58c', '黄色2', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '很好很好的黄色', '50', '25', '1', '25', '2018-07-10 14:48:22', '2018-07-10 14:48:22');
INSERT INTO `orders_product` VALUES ('2c8af9194f244a3dafc5b38a5b422600', 'f24731a04a504a46b108d0bcc6e6de8c', '5c8432d7b7674301a961d1803538e364', 'P002', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '时尚男装2', '商品简介2', null, '8c7f274a0ede4ccd82fe4e232b28f58c', '黄色2', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '很好很好的黄色', '50', '25', '1', '25', '2018-07-10 14:50:45', '2018-07-10 14:50:45');
INSERT INTO `orders_product` VALUES ('30ccf18aabbf45eb86300cb155a52094', 'c0049147b74c4c5cb91288f59c6fe190', '5c8432d7b7674301a961d1803538e364', 'P002', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '时尚男装2', '商品简介2', null, '9c33fd814e5e4d589440295aaa9116ef', '黄色', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '很好很好的黄色', '50', '25', '2', '50', '2018-07-10 18:22:44', '2018-07-10 18:22:44');
INSERT INTO `orders_product` VALUES ('4a9d346a15484ea881f8adb8a6cf580f', '00adb475cf5d459eab09b9074bd2ff59', '5c8432d7b7674301a961d1803538e364', 'P002', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '时尚男装2', '商品简介2', null, '8c7f274a0ede4ccd82fe4e232b28f58c', '黄色2', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '很好很好的黄色', '50', '25', '1', '25', '2018-07-10 18:42:31', '2018-07-10 18:42:31');
INSERT INTO `orders_product` VALUES ('4db1f327084e4eedaef4e560dda647eb', 'a907fdc465c44318ba7a0b6f55ec6b33', '5c8432d7b7674301a961d1803538e364', 'P002', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '时尚男装2', '商品简介2', null, '8c7f274a0ede4ccd82fe4e232b28f58c', '黄色2', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '很好很好的黄色', '50', '25', '1', '25', '2018-07-10 14:45:18', '2018-07-10 14:45:18');
INSERT INTO `orders_product` VALUES ('5433ce68232f4a8fb5808bbbbba463ce', '154c5bb373304bd58c52f2276f136d31', '5c8432d7b7674301a961d1803538e364', 'P002', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '时尚男装2', '商品简介2', null, '9c33fd814e5e4d589440295aaa9116ef', '黄色', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '很好很好的黄色', '50', '25', '2', '50', '2018-07-10 14:48:22', '2018-07-10 14:48:22');
INSERT INTO `orders_product` VALUES ('5586fb4c92614c6c8ee2c0c3782a2c4c', '172db51781764a538f06be03182e73a6', '5c8432d7b7674301a961d1803538e364', 'P002', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '时尚男装2', '商品简介2', null, '9c33fd814e5e4d589440295aaa9116ef', '黄色', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '很好很好的黄色', '50', '25', '2', '50', '2018-07-10 14:44:21', '2018-07-10 14:44:21');
INSERT INTO `orders_product` VALUES ('7413ad3ecaec4e458ae0694b8a0d2d26', '3297013118cc47649fe49fcc7c6f30c7', '5c8432d7b7674301a961d1803538e364', 'P002', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '时尚男装2', '商品简介2', null, '8c7f274a0ede4ccd82fe4e232b28f58c', '黄色2', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '很好很好的黄色', '50', '25', '1', '25', '2018-07-10 18:21:39', '2018-07-10 18:21:39');
INSERT INTO `orders_product` VALUES ('808e77ce790a48c6869f49426e74595e', '172db51781764a538f06be03182e73a6', '5c8432d7b7674301a961d1803538e364', 'P002', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '时尚男装2', '商品简介2', null, '8c7f274a0ede4ccd82fe4e232b28f58c', '黄色2', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '很好很好的黄色', '50', '25', '1', '25', '2018-07-10 14:44:21', '2018-07-10 14:44:21');
INSERT INTO `orders_product` VALUES ('8099461faba14701818c61726a90f0cd', '00adb475cf5d459eab09b9074bd2ff59', '5c8432d7b7674301a961d1803538e364', 'P002', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '时尚男装2', '商品简介2', null, '9c33fd814e5e4d589440295aaa9116ef', '黄色', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '很好很好的黄色', '50', '25', '2', '50', '2018-07-10 18:42:31', '2018-07-10 18:42:31');
INSERT INTO `orders_product` VALUES ('8917739217834982af31d34cf92a424e', '5e3bfd5c421d4c5eafc59dac32c28918', '5c8432d7b7674301a961d1803538e364', 'P002', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '时尚男装2', '商品简介2', null, '8c7f274a0ede4ccd82fe4e232b28f58c', '黄色2', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '很好很好的黄色', '50', '25', '1', '25', '2018-07-10 14:44:57', '2018-07-10 14:44:57');
INSERT INTO `orders_product` VALUES ('898509c27de9477cb10a79ca6bbf5a74', 'f24731a04a504a46b108d0bcc6e6de8c', '5c8432d7b7674301a961d1803538e364', 'P002', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '时尚男装2', '商品简介2', null, '9c33fd814e5e4d589440295aaa9116ef', '黄色', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '很好很好的黄色', '50', '25', '2', '50', '2018-07-10 14:50:45', '2018-07-10 14:50:45');
INSERT INTO `orders_product` VALUES ('8affdb4b21af49f5862be3627c9a763e', '3297013118cc47649fe49fcc7c6f30c7', '5c8432d7b7674301a961d1803538e364', 'P002', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '时尚男装2', '商品简介2', null, '9c33fd814e5e4d589440295aaa9116ef', '黄色', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '很好很好的黄色', '50', '25', '2', '50', '2018-07-10 18:21:39', '2018-07-10 18:21:39');
INSERT INTO `orders_product` VALUES ('9804e92367454890afc5df10b2c112e0', '5e3bfd5c421d4c5eafc59dac32c28918', '5c8432d7b7674301a961d1803538e364', 'P002', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '时尚男装2', '商品简介2', null, '9c33fd814e5e4d589440295aaa9116ef', '黄色', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '很好很好的黄色', '50', '25', '2', '50', '2018-07-10 14:44:57', '2018-07-10 14:44:57');
INSERT INTO `orders_product` VALUES ('9e76842400944616850080d911b86aee', 'a907fdc465c44318ba7a0b6f55ec6b33', '5c8432d7b7674301a961d1803538e364', 'P002', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '时尚男装2', '商品简介2', null, '9c33fd814e5e4d589440295aaa9116ef', '黄色', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '很好很好的黄色', '50', '25', '2', '50', '2018-07-10 14:45:18', '2018-07-10 14:45:18');
INSERT INTO `orders_product` VALUES ('baebfbfdf5a44a6d87d4299156d0df03', 'bf415b8674e54d60be83d1b9b5041cf5', '5c8432d7b7674301a961d1803538e364', 'P002', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '时尚男装2', '商品简介2', null, '8c7f274a0ede4ccd82fe4e232b28f58c', '黄色2', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '很好很好的黄色', '50', '25', '1', '25', '2018-07-10 14:48:09', '2018-07-10 14:48:09');
INSERT INTO `orders_product` VALUES ('d6a5662e95d24ce68421a484c8c08667', 'c0049147b74c4c5cb91288f59c6fe190', '5c8432d7b7674301a961d1803538e364', 'P002', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '时尚男装2', '商品简介2', null, '8c7f274a0ede4ccd82fe4e232b28f58c', '黄色2', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '很好很好的黄色', '50', '25', '1', '25', '2018-07-10 18:22:44', '2018-07-10 18:22:44');
INSERT INTO `orders_product` VALUES ('f86e6f315865419097d6a3b4cf3f87bb', 'bf415b8674e54d60be83d1b9b5041cf5', '5c8432d7b7674301a961d1803538e364', 'P002', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '时尚男装2', '商品简介2', null, '9c33fd814e5e4d589440295aaa9116ef', '黄色', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '很好很好的黄色', '50', '25', '2', '50', '2018-07-10 14:48:09', '2018-07-10 14:48:09');

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` varchar(64) NOT NULL COMMENT '主键',
  `code` varchar(255) DEFAULT NULL COMMENT '产品编码',
  `coverPic` varchar(255) DEFAULT NULL COMMENT '封面',
  `cyclePic` longtext COMMENT '轮播图',
  `productTitle` varchar(255) DEFAULT NULL COMMENT '标题',
  `productBrief` varchar(255) DEFAULT NULL COMMENT '产品简介',
  `productDesc` longtext COMMENT '产品详情介绍',
  `originalPrice` double DEFAULT NULL COMMENT '原价',
  `salePrice` double DEFAULT NULL COMMENT '售价',
  `salesVolume` int(11) DEFAULT NULL COMMENT '商品销量',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('2623d025237847fb9d3224dc9e00fb0d', 'p001', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '时尚的西裤', '很好很好', '<p>商品详情</p>', '50', '25', '0', '2018-06-29 18:08:02', '2018-06-29 18:08:02');
INSERT INTO `product` VALUES ('46c9e0baf3704b4e969b4a75b7023be4', 'P005', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '时尚男装5', '商品简介5', null, '50', '30', '0', '2018-06-27 18:01:17', '2018-06-27 18:01:17');
INSERT INTO `product` VALUES ('5c8432d7b7674301a961d1803538e364', 'P002', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '时尚男装2', '商品简介2', null, '50', '30', '0', '2018-06-27 18:00:35', '2018-06-27 18:00:35');
INSERT INTO `product` VALUES ('ce8f9abc9ba94fa18a62066158885cef', 'P004', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '时尚男装4', '商品简介4', null, '50', '30', '0', '2018-06-27 18:01:04', '2018-06-27 18:01:04');

-- ----------------------------
-- Table structure for `product_attr`
-- ----------------------------
DROP TABLE IF EXISTS `product_attr`;
CREATE TABLE `product_attr` (
  `id` varchar(64) NOT NULL COMMENT '主键',
  `productId` varchar(64) DEFAULT NULL COMMENT '商品ID',
  `attrName` varchar(255) DEFAULT NULL COMMENT '属性名称',
  `attrPic` varchar(255) DEFAULT NULL COMMENT '属性封面',
  `attrBrief` varchar(255) DEFAULT NULL COMMENT '属性简介',
  `originalPrice` double DEFAULT NULL COMMENT '原价',
  `salePrice` double DEFAULT NULL COMMENT '售价',
  `stockVolume` int(11) DEFAULT NULL COMMENT '商品库存',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品属性表';

-- ----------------------------
-- Records of product_attr
-- ----------------------------
INSERT INTO `product_attr` VALUES ('27b0e2828bcd4fa8921e97ddb3a46aeb', '5c8432d7b7674301a961d1803538e364', '黄色4', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '很好很好的黄色', '50', '25', '51', '2018-07-02 16:49:40', '2018-07-02 16:49:40');
INSERT INTO `product_attr` VALUES ('8c7f274a0ede4ccd82fe4e232b28f58c', '5c8432d7b7674301a961d1803538e364', '黄色2', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '很好很好的黄色', '50', '25', '51', '2018-07-02 16:49:30', '2018-07-02 16:49:30');
INSERT INTO `product_attr` VALUES ('9c33fd814e5e4d589440295aaa9116ef', '5c8432d7b7674301a961d1803538e364', '黄色', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '很好很好的黄色', '50', '25', '51', '2018-07-02 16:48:51', '2018-07-02 16:48:51');
INSERT INTO `product_attr` VALUES ('de25c0b1807845faa296a10e37130485', '5c8432d7b7674301a961d1803538e364', '黄色5', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '很好很好的黄色', '50', '25', '51', '2018-07-02 16:49:44', '2018-07-02 16:49:44');
INSERT INTO `product_attr` VALUES ('fd99d3461aad4878a47604641f1370ef', '5c8432d7b7674301a961d1803538e364', '黄色3', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '很好很好的黄色', '50', '25', '51', '2018-07-02 16:49:36', '2018-07-02 16:49:36');

-- ----------------------------
-- Table structure for `sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` varchar(64) NOT NULL COMMENT '主键',
  `code` varchar(255) DEFAULT NULL COMMENT '菜单编号',
  `pcode` varchar(255) DEFAULT NULL COMMENT '菜单父编号',
  `pcodes` varchar(600) DEFAULT NULL COMMENT '当前菜单的所有父菜单编号',
  `name` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `icon` varchar(255) DEFAULT NULL COMMENT '菜单图标',
  `url` varchar(255) DEFAULT NULL COMMENT 'url地址',
  `num` int(65) DEFAULT NULL COMMENT '菜单排序号',
  `levels` int(65) DEFAULT NULL COMMENT '菜单层级',
  `ismenu` int(11) DEFAULT NULL COMMENT '是否是菜单（1：是  0：不是）',
  `tips` varchar(255) DEFAULT NULL COMMENT '备注',
  `status` int(65) DEFAULT NULL COMMENT '菜单状态 :  1:启用   0:不启用',
  `isopen` int(11) DEFAULT NULL COMMENT '是否打开:  1:打开   0:不打开',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('30d1c5639e294d338d43277bbacfc9cf', 'mgr', 'system', '[0],[system],', '用户管理', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '/mgr', '1', '2', '1', '菜单', '1', '1', '2018-07-05 17:34:07', '2018-07-05 17:34:07');
INSERT INTO `sys_menu` VALUES ('92c22123175040b98ed83e094d908027', 'mgr_edit', 'mgr', '[0],[system],[mgr],', '修改用户', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '/mgr/edit', '2', '3', '0', '按钮', '1', '1', '2018-07-05 17:34:36', '2018-07-05 17:35:21');
INSERT INTO `sys_menu` VALUES ('c8ae71bf395b40d6bae1076374072c35', 'system', '0', '[0],', '系统管理', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '#', '1', '1', '1', '菜单', '1', '1', '2018-07-04 15:27:36', '2018-07-04 15:27:36');
INSERT INTO `sys_menu` VALUES ('ca32f561a7494e42a29dc9d2756ca85c', 'mgr_add', 'mgr', '[0],[system],[mgr],', '添加用户', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '/mgr/add', '1', '3', '0', '按钮', '1', '1', '2018-07-05 17:35:37', '2018-07-05 17:35:37');

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` varchar(64) NOT NULL COMMENT '主键',
  `num` int(11) DEFAULT NULL COMMENT '序号',
  `pid` varchar(255) DEFAULT NULL COMMENT '父角色id',
  `name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `tips` varchar(255) DEFAULT NULL COMMENT '提示',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('20a00e3f72a54f91a24cb903ac84083f', '1', '0', '超级管理员', '拥有所有权限', '2018-07-05 18:21:08', '2018-07-05 18:21:08');
INSERT INTO `sys_role` VALUES ('37bb7512a139454a94fde8dff37d8188', '2', null, '管理员3', '拥有部分权限', '2018-07-05 18:32:40', '2018-07-05 18:32:40');
INSERT INTO `sys_role` VALUES ('89a8af80fc7c418eabf6fddb1793e6b3', '3', null, '管理员2', '拥有部分权限', '2018-07-05 18:32:34', '2018-07-05 18:32:34');
INSERT INTO `sys_role` VALUES ('cb181c07d0564a5aacda05dc0a801d39', '4', null, '管理员', '拥有部分权限', '2018-07-05 18:32:16', '2018-07-05 18:32:16');

-- ----------------------------
-- Table structure for `sys_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` varchar(64) NOT NULL COMMENT '主键',
  `roleId` varchar(255) DEFAULT NULL COMMENT '角色id',
  `menuId` varchar(255) DEFAULT NULL COMMENT '菜单id',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色与菜单关联表';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('6114f72799824398bc4a1cf96cf0bfbf', '20a00e3f72a54f91a24cb903ac84083f', 'ca32f561a7494e42a29dc9d2756ca85c', '2018-07-06 14:54:35', '2018-07-06 14:54:35');
INSERT INTO `sys_role_menu` VALUES ('8f50bf8091574f49823d982a32f56e1d', '20a00e3f72a54f91a24cb903ac84083f', 'c8ae71bf395b40d6bae1076374072c35', '2018-07-06 14:54:35', '2018-07-06 14:54:35');
INSERT INTO `sys_role_menu` VALUES ('eb56e11aa16f4f5f86d8e8a913cc0a89', '20a00e3f72a54f91a24cb903ac84083f', '30d1c5639e294d338d43277bbacfc9cf', '2018-07-06 14:54:35', '2018-07-06 14:54:35');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(64) NOT NULL COMMENT '主键',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `account` varchar(45) DEFAULT NULL COMMENT '账号',
  `password` varchar(45) DEFAULT NULL COMMENT '密码',
  `userName` varchar(45) DEFAULT NULL COMMENT '名字',
  `userSex` int(11) DEFAULT NULL COMMENT '性别（1：男 2：女 3：未知）',
  `userEmail` varchar(45) DEFAULT NULL COMMENT '电子邮件',
  `userPhone` varchar(45) DEFAULT NULL COMMENT '电话',
  `userType` int(11) DEFAULT NULL COMMENT '用户类型(1：管理员  2：普通用户）',
  `status` int(11) DEFAULT NULL COMMENT '状态(1：启用  2：冻结  3：删除）',
  `userMoney` double DEFAULT NULL COMMENT '用户余额',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('21f4712fdbe54393a8f91f9474fcea65', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '15088132167', '123456', '郭靖3', '1', '2630344884@qq.com', '15088132167', '1', '1', '0', '2018-07-03 16:50:03', '2018-07-03 16:50:03');
INSERT INTO `sys_user` VALUES ('56fe60c239d94977a5e05114a8bcd1a7', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '15088132169', '123456', '郭靖2', '1', '2630344884@qq.com', '15088132169', '1', '1', '0', '2018-07-03 16:49:20', '2018-07-03 16:49:20');
INSERT INTO `sys_user` VALUES ('618eb09683d946ddb747a5b8ebc300e4', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '15088132168', '123456', '郭靖', '1', '2630344884@qq.com', '15088132168', '1', '1', '0', '2018-07-03 16:03:42', '2018-07-03 16:03:42');
INSERT INTO `sys_user` VALUES ('861aa2703f1a4f04bb448e3ac07d2ad8', 'http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg', '15088132168', '123456', '普通郭靖', '1', '2630344884@qq.com', '15088132168', '2', '1', '0', '2018-07-09 14:50:08', '2018-07-09 14:50:08');

-- ----------------------------
-- Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` varchar(64) NOT NULL COMMENT '主键',
  `userId` varchar(255) DEFAULT NULL COMMENT '用户id',
  `roleId` varchar(255) DEFAULT NULL COMMENT '角色id',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户与角色关联表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('da859f2f9466416292ac12a2b3a241fe', '618eb09683d946ddb747a5b8ebc300e4', '20a00e3f72a54f91a24cb903ac84083f', '2018-07-06 15:28:24', '2018-07-06 15:28:24');
