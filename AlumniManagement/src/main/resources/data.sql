INSERT INTO department (id,department_name) VALUES (1,'Development');
INSERT INTO department (id,department_name) VALUES (2,'Quality Assistance');

INSERT INTO address (id,city,state) VALUES (1,'Fairfield','IOWA');
INSERT INTO address (id,city,state) VALUES (2,'Fairfield','OHIO');

INSERT INTO student (id,email,first_name,last_name,id_address,gpa,id_major,user_id) VALUES (1,'apokhrel@miu.edu','Ashish','Pokhrel',1,4,1,1);
INSERT INTO student (id,email,first_name,last_name,id_address,gpa,id_major,user_id) VALUES (2,'pbudhathoki@miu.edu','Puskar','Budhatoki',1,4,1,1);
INSERT INTO student (id,email,first_name,last_name,id_address,gpa,id_major,user_id) VALUES (3,'spageni@miu.edu','Saugat','Pageni',1,4,1,1);
INSERT INTO student (id,email,first_name,last_name,id_address,gpa,id_major,user_id) VALUES (4,'akc@miu.edu','Anand','Kc',1,4,1,1);
INSERT INTO student (id,email,first_name,last_name,id_address,gpa,id_major,user_id) VALUES (5,'sudip@miu.edu','Sudip','Budhatoki',1,4,1,1);
INSERT INTO student (id,email,first_name,last_name,id_address,gpa,id_major,user_id) VALUES (6,'sp@miu.edu','Sudip2','Budhatoki2',1,4,1,1);

INSERT INTO job_advertisement (id,add_benefit,company_name,job_desc,job_title,student_id,num_opening,payment_amount,id_address) VALUES (1,'good salary with bonus','Infosys','Mid level java developer needed in Infosys','java Developer',1,5,1231,1);
INSERT INTO job_advertisement (id,add_benefit,company_name,job_desc,job_title,student_id,num_opening,payment_amount,id_address) VALUES (2,'good salary with bonus','Data Sys','Top level developer needed ','.Net Developer',2,10,16516,2);
INSERT INTO job_advertisement (id,add_benefit,company_name,job_desc,job_title,student_id,num_opening,payment_amount,id_address) VALUES (3,'good salary with bonus','Cotivity','Mid level developer needed ','Backend Developer',1,5,1231,1);
INSERT INTO job_advertisement (id,add_benefit,company_name,job_desc,job_title,student_id,num_opening,payment_amount,id_address) VALUES (4,'good salary with bonus','F1','Mid level developer needed in Infosys','FrontEnd Developer',2,10,16516,2);
INSERT INTO job_advertisement (id,add_benefit,company_name,job_desc,job_title,student_id,num_opening,payment_amount,id_address) VALUES (5,'good salary with bonus','Javra','developer needed','java Developer',1,5,1231,1);
INSERT INTO job_advertisement (id,add_benefit,company_name,job_desc,job_title,student_id,num_opening,payment_amount,id_address) VALUES (6,'good salary with bonus','Data One','Mid level developer needed in Infosys','.Net Developer',2,10,16516,2);
INSERT INTO job_advertisement (id,add_benefit,company_name,job_desc,job_title,student_id,num_opening,payment_amount,id_address) VALUES (7,'good salary with bonus','Infosys Two','Mid level java developer needed in Infosys','MongoDb Developer',1,5,1231,1);
INSERT INTO job_advertisement (id,add_benefit,company_name,job_desc,job_title,student_id,num_opening,payment_amount,id_address) VALUES (8,'good salary with bonus','Data Sys Mgmt','Mid level developer needed in Infosys','Spring Developer',2,10,16516,2);
INSERT INTO job_advertisement (id,add_benefit,company_name,job_desc,job_title,student_id,num_opening,payment_amount,id_address) VALUES (9,'good salary with bonus','Infosys Dev','Mid level java developer needed in Infosys','java Developer',1,5,1231,1);
INSERT INTO job_advertisement (id,add_benefit,company_name,job_desc,job_title,student_id,num_opening,payment_amount,id_address) VALUES (10,'good salary with bonus','Data Sys INfo','Mid level developer needed in Infosys','.Net Developer',2,10,16516,2);
INSERT INTO job_advertisement (id,add_benefit,company_name,job_desc,job_title,student_id,num_opening,payment_amount,id_address) VALUES (11,'good salary with bonus',' INfo','Top level developer needed in Infosys','.Net Developer',2,10,16516,2);


INSERT INTO faculty (id, active, department, email, first_name, last_logged_in_at, last_name, password, id_address) VALUES (1, true,'cs','faculty@miu.edu','Bibek','2022-01-15','Thokar','admin123',1);

INSERT INTO comment (id, comment, is_active, is_deleted, faculty_id, student_id) VALUES (1, 'Extraordinary Student',true,false,1,1);
INSERT INTO comment (id, comment, is_active, is_deleted, faculty_id, student_id) VALUES (2, 'Good boy.',true,false,1,1);
INSERT INTO comment (id, comment, is_active, is_deleted, faculty_id, student_id) VALUES (3, 'Fresh boy',true,false,1,2);





