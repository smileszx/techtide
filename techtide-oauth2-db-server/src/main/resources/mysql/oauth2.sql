CREATE DATABASE `oauth2` CHARACTER SET 'utf8';

/*Table structure for the table `oauth_access_token` */
DROP TABLE IF EXISTS `oauth_access_token`;
CREATE TABLE `oauth_access_token` (
`token_id` VARCHAR(256) DEFAULT NULL,
`token` BLOB,
`authentication_id` VARCHAR(48) NOT NULL,
`user_name` VARCHAR(256) DEFAULT NULL,
`client_id` VARCHAR(256) DEFAULT NULL,
`authentication` BLOB,
`refresh_token` VARCHAR(256) DEFAULT NULL,
PRIMARY KEY (`authentication_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Table structure for table `oauth_approvals` */
DROP TABLE IF EXISTS `oauth_approvals`;
CREATE TABLE `oauth_approvals` (
`userId` VARCHAR(256) DEFAULT NULL,
`clientId` VARCHAR(256) DEFAULT NULL,
`scope` VARCHAR(256) DEFAULT NULL,
`status` VARCHAR(10) DEFAULT NULL,
`expiresAt` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE
CURRENT_TIMESTAMP,
`lastModifiedAt` TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Table structure for table `oauth_client_details` */
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details` (
`client_id` VARCHAR(48) NOT NULL,
`resource_ids` VARCHAR(256) DEFAULT NULL,
`client_secret` VARCHAR(256) DEFAULT NULL,
`scope` VARCHAR(256) DEFAULT NULL,
`authorized_grant_types` VARCHAR(256) DEFAULT NULL,
`web_server_redirect_uri` VARCHAR(256) DEFAULT NULL,
`authorities` VARCHAR(256) DEFAULT NULL,
`access_token_validity` INT(11) DEFAULT NULL,
`refresh_token_validity` INT(11) DEFAULT NULL,
`additional_information` VARCHAR(4096) DEFAULT NULL,
`autoapprove` VARCHAR(256) DEFAULT NULL,
PRIMARY KEY (`client_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Table structure for table `oauth_client_token` */
DROP TABLE IF EXISTS `oauth_client_token`;
CREATE TABLE `oauth_client_token` (
`token_id` VARCHAR(256) DEFAULT NULL,
`token` BLOB,
`authentication_id` VARCHAR(48) NOT NULL,
`user_name` VARCHAR(256) DEFAULT NULL,
`client_id` VARCHAR(256) DEFAULT NULL,
PRIMARY KEY (`authentication_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Table structure for table `oauth_code` */
DROP TABLE IF EXISTS `oauth_code`;
CREATE TABLE `oauth_code` (
`code` VARCHAR(256) DEFAULT NULL,
`authentication` BLOB
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Table structure for table `oauth_refresh_token` */
DROP TABLE IF EXISTS `oauth_refresh_token`;
CREATE TABLE `oauth_refresh_token` (
`token_id` VARCHAR(256) DEFAULT NULL,
`token` BLOB,
`authentication` BLOB
) ENGINE=INNODB DEFAULT CHARSET=utf8;