CREATE TABLE `tm_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL DEFAULT '',
  `name` varchar(50) NOT NULL DEFAULT '',
  `password` varchar(100) NOT NULL DEFAULT '',
  `role` varchar(40) NOT NULL DEFAULT 'ROLE_USER',
  PRIMARY KEY (`id`)
);

