INSERT INTO api_user (code, description, name, display_name, email, password, username) VALUES( 10, 'First group ever... :)', 'Atanas', 'Admin user', 'admin@xaos.com', '$2a$10$OsSAnz0XoHE9.7x7tWOnIOp0XcGlY8RH3n8aX/b33NHvcDdcfGlk.', 'admin');
INSERT INTO api_user (code, description, name, display_name, email, password, username) VALUES( 21, 'Secong group ever... :)', 'Ivan', 'Simple user - modified', 'user@xaos.com', '$2a$10$hmWDJoogjwaRvNojlkW8sOITEYqYSe2hPCyWPiLcAffG/KYAuLxJa', 'user');

INSERT INTO api_group (code, description, name, display_name) VALUES(10, 'First group ever... :)', 'ADMIN', 'Display Name AG');
INSERT INTO api_group (code, description, name, display_name) VALUES(21, 'Secong group ever... :) - a', 'USERS', 'Display Name AG - 2a');
INSERT INTO api_group (code, description, name, display_name) VALUES(30, 'Last group ever... :)', 'USERS2', 'Display Name AG-3');

INSERT INTO api_group_user (api_group_id, api_user_id) VALUES(1, 1);
INSERT INTO api_group_user (api_group_id, api_user_id) VALUES(2, 1);
INSERT INTO api_group_user (api_group_id, api_user_id) VALUES(2, 2);

INSERT INTO faculty (code, description, name) VALUES(10, 'First group ever... :)', 'Group 1');
INSERT INTO faculty (code, description, name) VALUES(21, 'Secong group ever... :)', 'Group 2a');
INSERT INTO faculty (code, description, name) VALUES(30, 'Last group ever... :)', 'Group 3');

INSERT INTO department (code, description, name, faculty_id) VALUES(10, 'First group ever... :)', 'Group 1', 1);
INSERT INTO department (code, description, name, faculty_id) VALUES(21, 'Secong group ever... :)', 'Group 2a', 2);

INSERT INTO discipline (code, description, name) VALUES(10, 'First group ever... :)', 'Group 1');
INSERT INTO discipline (code, description, name) VALUES(21, 'Secong group ever... :)', 'Group 2a');
INSERT INTO discipline (code, description, name) VALUES(30, 'Last group ever... :)', 'Group 3');

INSERT INTO faculty_discipline (discipline_id, faculty_id) VALUES(1, 1);
INSERT INTO faculty_discipline (discipline_id, faculty_id) VALUES(2, 2);

INSERT INTO lecturer (code, description, name, family_name, api_user_id, department_id) VALUES(10, 'First group ever... :)', 'Group 1', 'Family name - 1', 1, 1);
INSERT INTO lecturer (code, description, name, family_name, api_user_id, department_id) VALUES(21, 'Secong group ever... :)', 'Group 2a', 'Family name - 2', 2, 2);

INSERT INTO speciality (code, description, name, faculty_id) VALUES(10, 'First group ever... :)', 'Group 1', 2);
INSERT INTO speciality (code, description, name, faculty_id) VALUES(21, 'Secong group ever... :)', 'Group 2a', 1);
INSERT INTO speciality (code, description, name, faculty_id) VALUES(30, 'Last group ever... :)', 'Group 3', 1);

