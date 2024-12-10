-- Insert sample data for SkillCategory Table
INSERT INTO skill_category (skill_category_id) VALUES (1);
INSERT INTO skill_category (skill_category_id) VALUES (2);

-- Insert sample data for Skill Table
INSERT INTO skill (skill_id, skill_category_id, skill_name) VALUES (1, 1, 'Java');
INSERT INTO skill (skill_id, skill_category_id, skill_name) VALUES (2, 1, 'Spring');
INSERT INTO skill (skill_id, skill_category_id, skill_name) VALUES (3, 2, 'JavaScript');

-- Insert sample data for Engineer Table
INSERT INTO engineer (engineer_id, engineer_name) VALUES (1, 'John Doe');
INSERT INTO engineer (engineer_id, engineer_name) VALUES (2, 'Jane Smith');

-- Insert sample data for EngineerSkill Table
INSERT INTO engineer_skill (engineer_id, skill_id) VALUES (1, 1);
INSERT INTO engineer_skill (engineer_id, skill_id) VALUES (1, 2);
INSERT INTO engineer_skill (engineer_id, skill_id) VALUES (2, 3);
