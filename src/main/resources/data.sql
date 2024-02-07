INSERT INTO MEMBER (member_seq, member_id,member_type,name,password,signup_type) VALUES (NEXTVAL('member_seq'), 'tester','USER','박준일','$2a$12$/mWSK223uPimU7sJakwPb.pdWdbkuDzSlhnU7dbkA.2BHg0HZGo1e','SITE');
INSERT INTO MEMBER (member_seq, member_id,member_type,name,password,signup_type) VALUES (NEXTVAL('member_seq'), 'tester1','USER','테스터','$2a$12$SDDsdgES1PQw.3NloB0O..gUVJ2Kc36iVbAgbnsKME/9aBgnHAtpy','SITE');

-- 일반초대장 데이터 입력
INSERT INTO BASE_OPTION (bo_seq, bo_code, name, invite_type,priority) values (NEXTVAL('base_option_seq'), 'BASEOPTION_1','초대문구','DEFAULT',1);
INSERT INTO BASE_OPTION (bo_seq, bo_code, name, invite_type,priority) values (NEXTVAL('base_option_seq'), 'BASEOPTION_2','달력','DEFAULT',4);
INSERT INTO BASE_OPTION (bo_seq, bo_code, name, invite_type,priority) values (NEXTVAL('base_option_seq'), 'BASEOPTION_3','연락처','DEFAULT',3);
INSERT INTO BASE_OPTION (bo_seq, bo_code, name, invite_type,priority) values (NEXTVAL('base_option_seq'), 'BASEOPTION_4','사진(슬라이드 10장)','DEFAULT',2);
INSERT INTO BASE_OPTION (bo_seq, bo_code, name, invite_type,priority) values (NEXTVAL('base_option_seq'), 'BASEOPTION_5','지도','DEFAULT',5);
