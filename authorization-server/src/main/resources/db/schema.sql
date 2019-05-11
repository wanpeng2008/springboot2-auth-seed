DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details` (
                                        `client_id` varchar(48) NOT NULL,
                                        `resource_ids` varchar(256) DEFAULT NULL,
                                        `client_secret` varchar(256) DEFAULT NULL,
                                        `scope` varchar(256) DEFAULT NULL,
                                        `authorized_grant_types` varchar(256) DEFAULT NULL,
                                        `web_server_redirect_uri` varchar(256) DEFAULT NULL,
                                        `authorities` varchar(256) DEFAULT NULL,
                                        `access_token_validity` int(11) DEFAULT NULL,
                                        `refresh_token_validity` int(11) DEFAULT NULL,
                                        `additional_information` varchar(4096) DEFAULT NULL,
                                        `autoapprove` varchar(256) DEFAULT NULL,
                                        PRIMARY KEY (`client_id`)
);
DROP TABLE IF EXISTS `t_user`;
create table `t_user` (
                                    ID int not null primary key auto_increment,
                                    USERNAME varchar(100) NOT NULL UNIQUE ,
                                    PASSWORD varchar(100) NOT NULL);
DROP TABLE IF EXISTS `t_role`;
create table `t_role` (
                          role_code varchar(100) primary key NOT NULL ,
                          role_name varchar(100) NOT NULL);
DROP TABLE IF EXISTS `t_permission`;
create table `t_permission` (
                          permission_code varchar(100) primary key NOT NULL ,
                          permission_name varchar(100) NOT NULL);

DROP TABLE IF EXISTS `t_user_role`;
create table `t_user_role` (
                          user_id int NOT NULL ,
                          role_code varchar(100) NOT NULL,
                          PRIMARY KEY (user_id, role_code)
);

DROP TABLE IF EXISTS `t_role_permission`;
create table `t_role_permission` (
                          role_code varchar(100) NOT NULL ,
                          permission_code varchar(100) NOT NULL,
                          PRIMARY KEY (role_code, permission_code)
);
