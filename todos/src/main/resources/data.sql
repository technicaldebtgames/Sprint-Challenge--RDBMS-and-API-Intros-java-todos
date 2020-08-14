DELETE FROM todos;
DELETE FROM users;

INSERT INTO users (userid, username, password, primaryemail, created_by, created_date, last_modified_by, last_modified_date)
    VALUES (1, 'admin', 'password', 'admin@lambdaschool.local', 'llama', CURRENT_TIMESTAMP, 'llama', CURRENT_TIMESTAMP),
           (2, 'cinnamon', '1234567',  'cinnamon@lambdaschool.local', 'llama', CURRENT_TIMESTAMP, 'llama', CURRENT_TIMESTAMP),
           (3, 'barnbarn', 'ILuvM4th!', 'barnbarn@lambdaschool.local', 'llama', CURRENT_TIMESTAMP, 'llama', CURRENT_TIMESTAMP),
           (4, 'puttat', 'password', 'puttat@school.lambda', 'llama', CURRENT_TIMESTAMP, 'llama', CURRENT_TIMESTAMP),
           (5, 'misskitty', 'password', 'misskitty@school.lambda', 'llama', CURRENT_TIMESTAMP, 'llama', CURRENT_TIMESTAMP);

INSERT INTO todos (todoid, description, completed, userid, created_by, created_date, last_modified_by, last_modified_date)
    VALUES (1, 'Give Joe access rights', false, 1, 'llama', CURRENT_TIMESTAMP, 'llama', CURRENT_TIMESTAMP),
           (2, 'Change the color of the home page', false, 1, 'llama', CURRENT_TIMESTAMP, 'llama', CURRENT_TIMESTAMP),
           (3, 'Take a nap', false, 2, 'llama', CURRENT_TIMESTAMP, 'llama', CURRENT_TIMESTAMP),
           (4, 'Rearrange my hutch', false, 2, 'llama', CURRENT_TIMESTAMP, 'llama', CURRENT_TIMESTAMP),
           (5, 'Groom my fur', false, 2, 'llama', CURRENT_TIMESTAMP, 'llama', CURRENT_TIMESTAMP),
           (6, 'Rearrange my hutch', false, 3, 'llama', CURRENT_TIMESTAMP, 'llama', CURRENT_TIMESTAMP);

ALTER SEQUENCE hibernate_sequence RESTART WITH 50;