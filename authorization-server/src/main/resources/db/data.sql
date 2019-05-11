-- INSERT INTO USER (USE_ID,USE_NAME,USE_SEX,USE_AGE,USE_ID_NO,USE_PHONE_NUM,USE_EMAIL,CREATE_TIME,MODIFY_TIME,USE_STATE) VALUES(
--                                                                                                                                  1,'赵一','0',20,'142323198610051234','12345678910','qe259@163.com',sysdate,sysdate,'0');
-- INSERT INTO USER (USE_ID,USE_NAME,USE_SEX,USE_AGE,USE_ID_NO,USE_PHONE_NUM,USE_EMAIL,CREATE_TIME,MODIFY_TIME,USE_STATE) VALUES(
--                                                                                                                                  2,'钱二','0',22,'142323198610051235','12345678911','qe259@164.com',sysdate,sysdate,'0');
-- INSERT INTO USER (USE_ID,USE_NAME,USE_SEX,USE_AGE,USE_ID_NO,USE_PHONE_NUM,USE_EMAIL,CREATE_TIME,MODIFY_TIME,USE_STATE) VALUES(
--                                                                                                                                  3,'孙三','1',24,'142323198610051236','12345678912','qe259@165.com',sysdate,sysdate,'0');


INSERT INTO oauth_client_details (client_id, authorized_grant_types, client_secret, scope, access_token_validity) VALUES ( 'reader', 'password', '{bcrypt}$2a$10$Q5sRVIU/r3NySHqmMUFVDu5.epwFZX0x7ldmT3YsQ8M.3nOpEdsWy', 'message:read', 600000000 ); -- {noop}secret
INSERT INTO oauth_client_details (client_id, authorized_grant_types, client_secret, scope, access_token_validity) VALUES ( 'writer', 'password', '{bcrypt}$2a$10$HJkNYxSoGBplHDxsK8brzOkX2Le2y8mgUvyN8Ol978DBTlSU1UBZa', 'message:write', 600000000 ); -- {noop}secret
INSERT INTO oauth_client_details (client_id, authorized_grant_types, client_secret, scope, access_token_validity) VALUES ( 'noscopes', 'password', '{bcrypt}$2a$10$HJkNYxSoGBplHDxsK8brzOkX2Le2y8mgUvyN8Ol978DBTlSU1UBZa', 'none', 600000000 );


INSERT INTO T_USER (ID, USERNAME, PASSWORD) VALUES ( 1, 'subject', '{bcrypt}$2a$10$Jg6FHegIvGagS1U/4MnlzeyNB/EMxpC74wioHgsghotO8zoJakHnu' ); --'{noop}password'

INSERT INTO T_ROLE (ROLE_CODE, ROLE_NAME) VALUES ( 'ADMIN', '管理员' );

INSERT INTO T_PERMISSION (PERMISSION_CODE, PERMISSION_NAME) VALUES ( 'AUTH_ALL', '所有权限' );

INSERT INTO T_USER_ROLE (USER_ID, ROLE_CODE) VALUES ( 1, 'ADMIN' );

INSERT INTO T_ROLE_PERMISSION (ROLE_CODE, PERMISSION_CODE) VALUES ( 'ADMIN', 'AUTH_ALL' );