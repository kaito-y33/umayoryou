-- ENGINEER テーブルにデータ挿入
INSERT INTO engineer (engineer_name, position) VALUES
('John Doe', 'Senior Engineer'),
('Jane Smith', 'Junior Engineer'),
('Alice Johnson', 'Lead Engineer'),
('Bob Brown', 'Engineer');

-- PROJECT テーブルにデータ挿入
INSERT INTO project (project_name, description, start_date, end_date, status) VALUES
('Project Alpha', 'This is the description for Project Alpha.', '2024-01-01', '2024-06-30', 'ACTIVE'),
('Project Beta', 'This is the description for Project Beta.', '2024-03-01', '2024-12-31', 'ACTIVE'),
('Project Gamma', 'This is the description for Project Gamma.', '2024-07-01', '2025-01-31', 'COMPLETED');

-- PROJECT_ENGINEERS テーブルにデータ挿入
INSERT INTO project_engineers (project_id, engineer_id) VALUES
(1, 1), -- John Doe is assigned to Project Alpha
(1, 2), -- Jane Smith is assigned to Project Alpha
(2, 3), -- Alice Johnson is assigned to Project Beta
(2, 4), -- Bob Brown is assigned to Project Beta
(3, 1); -- John Doe is assigned to Project Gamma

-- ENGINEER_SKILLS テーブルにデータ挿入
INSERT INTO engineer_skill (engineer_id) VALUES
(1), -- John Doe
(2), -- Jane Smith
(3), -- Alice Johnson
(4); -- Bob Brown

-- LANGUAGE テーブルにデータ挿入 (プログラミング言語)
INSERT INTO language (language_name) VALUES
('Python'),
('Java'),
('JavaScript'),
('C#'),
('Ruby'),
('Go');

-- LANGUAGE_SKILL テーブルにデータ挿入
INSERT INTO language_skill (engineer_skill_id, language_id, level) VALUES
(1, 1, 5), -- John Doe: Python level 5
(2, 2, 3), -- Jane Smith: Java level 3
(3, 3, 4), -- Alice Johnson: JavaScript level 4
(4, 4, 2), -- Bob Brown: C# level 2
(1, 5, 4), -- John Doe: Ruby level 4
(2, 6, 3); -- Jane Smith: Go level 3

-- TOOL テーブルにデータ挿入
INSERT INTO tool (tool_name) VALUES
('Docker'),
('Kubernetes'),
('Git'),
('JIRA');

-- TOOL_SKILL テーブルにデータ挿入
INSERT INTO tool_skill (engineer_skill_id, tool_id, level) VALUES
(1, 1, 4), -- John Doe: Docker level 4
(2, 2, 3), -- Jane Smith: Kubernetes level 3
(3, 3, 5), -- Alice Johnson: Git level 5
(4, 4, 2); -- Bob Brown: JIRA level 2
