-- Drop tables if they exist
DROP TABLE IF EXISTS engineer_skill;
DROP TABLE IF EXISTS skill;
DROP TABLE IF EXISTS skill_category;
DROP TABLE IF EXISTS engineer;

-- Engineer Table
CREATE TABLE IF NOT EXISTS engineer (
    engineer_id INT PRIMARY KEY,
    engineer_name VARCHAR(255) NOT NULL
);

-- SkillCategory Table
CREATE TABLE IF NOT EXISTS skill_category (
    skill_category_id INT PRIMARY KEY
);

-- Skill Table
CREATE TABLE IF NOT EXISTS skill (
    skill_id INT PRIMARY KEY,
    skill_category_id INT,
    skill_name VARCHAR(255) NOT NULL,
    FOREIGN KEY (skill_category_id) REFERENCES skill_category(skill_category_id)
);

-- EngineerSkill Table
CREATE TABLE IF NOT EXISTS engineer_skill (
    engineer_id INT,
    skill_id INT,
    PRIMARY KEY (engineer_id, skill_id),
    FOREIGN KEY (engineer_id) REFERENCES engineer(engineer_id),
    FOREIGN KEY (skill_id) REFERENCES skill(skill_id)
);