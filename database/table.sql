CREATE TABLE `tm_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL DEFAULT '',
  `name` varchar(50) NOT NULL DEFAULT '',
  `password` varchar(100) NOT NULL DEFAULT '',
  `role` varchar(40) NOT NULL DEFAULT 'ROLE_USER',
  PRIMARY KEY (`id`)
);


CREATE TABLE `tm_order` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL DEFAULT '',
  `record_date` DATE  NOT NULL DEFAULT '0000-00-00',
  `quantity` smallint(4) NOT NULL DEFAULT 0,
  `insert_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `unit_price` DECIMAL(8,2) NOT NULL DEFAULT 0.00,
  `currency` varchar(10) NOT NULL DEFAULT 'euro',
  `exchange_rate` DECIMAL(5,4) NOT NULL DEFAULT '0.0000',
  `order_number` varchar(100) NOT NULL DEFAULT '',
   PRIMARY KEY (`id`)
);


CREATE TABLE `tm_buying` (
  `order_id` bigint(20) unsigned NOT NULL,
  `payer` varchar(50) NOT NULL DEFAULT '',
  `arrive_date` DATE  NOT NULL DEFAULT '0000-00-00',
  `remain` smallint(4) NOT NULL DEFAULT 0,
  `is_stockpile` tinyint(1) NOT NULL DEFAULT 0,
   PRIMARY KEY (`order_id`),
   FOREIGN KEY (`order_id`) REFERENCES `tm_order` (`id`)
);


CREATE TABLE `tm_selling` (
  `order_id` bigint(20) unsigned NOT NULL,
  `sell_unit_price` DECIMAL(8,2) NOT NULL DEFAULT 0.00,
  `postage` DECIMAL(6,2) NOT NULL DEFAULT 0.00,
  `sell_currency` varchar(10) NOT NULL DEFAULT 'cny',
  `stockpile_id` bigint(20) unsigned DEFAULT 0,
  `reduced_price` DECIMAL(8,2) NOT NULL DEFAULT 0.00,
  `is_received` tinyint(1) NOT NULL DEFAULT 0,
  `is_refund` tinyint(1) NOT NULL DEFAULT 0,
  `is_sold_to_friend` tinyint(1) NOT NULL DEFAULT 0,
  `is_brush` tinyint(1) NOT NULL DEFAULT 0,
  `is_repay_brush_buyer` tinyint(1) NOT NULL DEFAULT 0,
  `buyer` varchar(50) NOT NULL DEFAULT '',
  `deliver_date` DATE  NOT NULL DEFAULT '0000-00-00',
  `product_id` bigint(4) unsigned NOT NULL,
   PRIMARY KEY (`order_id`),
   FOREIGN KEY (`order_id`) REFERENCES `tm_order` (`id`)
);
