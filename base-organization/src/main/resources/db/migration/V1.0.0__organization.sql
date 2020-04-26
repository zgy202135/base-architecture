
-- ----------------------------
-- Schema structure for svms_fs
-- ----------------------------
create database IF NOT EXISTS svms_organization character set UTF8;
use svms_organization;
set character set UTF8;
set character_set_database=UTF8;
set character_set_connection=UTF8;
set character_set_results=UTF8;
set character_set_client=UTF8;
set FOREIGN_KEY_CHECKS=0;
set AUTOCOMMIT=0;
-- ----------------------------
-- Table structure for flyway_schema_history
-- ----------------------------
CREATE TABLE IF NOT EXISTS `flyway_schema_history` (
  `installed_rank` int(11) NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int(11) DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` int(11) NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  KEY `flyway_schema_history_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
SET FOREIGN_KEY_CHECKS=1;