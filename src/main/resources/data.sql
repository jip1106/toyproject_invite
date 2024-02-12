INSERT INTO MEMBER (member_seq, member_id,member_type,name,password,signup_type) VALUES (NEXTVAL('member_seq'), 'tester','USER','박준일','$2a$12$/mWSK223uPimU7sJakwPb.pdWdbkuDzSlhnU7dbkA.2BHg0HZGo1e','SITE');
INSERT INTO MEMBER (member_seq, member_id,member_type,name,password,signup_type) VALUES (NEXTVAL('member_seq'), 'tester1','USER','테스터','$2a$12$SDDsdgES1PQw.3NloB0O..gUVJ2Kc36iVbAgbnsKME/9aBgnHAtpy','SITE');

-- 일반초대장 데이터 입력
INSERT INTO BASE_OPTION (bo_seq, bo_code, name, invite_type,priority,dup_check,description) values (NEXTVAL('base_option_seq'), 'BASEOPTION_1','배경색상','DEFAULT',1,true,'배경색상을 지정합니다.');
INSERT INTO BASE_OPTION (bo_seq, bo_code, name, invite_type,priority,dup_check,description) values (NEXTVAL('base_option_seq'), 'BASEOPTION_2','문구','DEFAULT',2,true,'문구를 작성합니다 스타일을 지정할 수 있습니다.');
INSERT INTO BASE_OPTION (bo_seq, bo_code, name, invite_type,priority,dup_check,description) values (NEXTVAL('base_option_seq'), 'BASEOPTION_3','달력','DEFAULT',3,false, '기념일 날짜를 선택합니다. 달력으로 표기 됩니다.');
INSERT INTO BASE_OPTION (bo_seq, bo_code, name, invite_type,priority,dup_check,description) values (NEXTVAL('base_option_seq'), 'BASEOPTION_4','연락처','DEFAULT',5,true, '연락처를 표시 합니다.');
INSERT INTO BASE_OPTION (bo_seq, bo_code, name, invite_type,priority,dup_check,description) values (NEXTVAL('base_option_seq'), 'BASEOPTION_5','사진','DEFAULT',4,true, '사진을 업로드 합니다.');
INSERT INTO BASE_OPTION (bo_seq, bo_code, name, invite_type,priority,dup_check,description) values (NEXTVAL('base_option_seq'), 'BASEOPTION_6','지도','DEFAULT',6,false,'지도를 표시 합니다.');
