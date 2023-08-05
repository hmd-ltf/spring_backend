INSERT INTO b_roles (code, name, details)
VALUES
    ('A', 'Admin', 'Admin'),
    ('U', 'User', 'User'),
    ('V', 'Viewer', 'Viewer');

INSERT INTO b_statuses (code, name, details)
VALUES
    ('P', 'Paused', 'Paused'),
    ('W', 'Working', 'Working'),
    ('C', 'Completed', 'Completed'),
    ('F', 'Failed', 'Failed'),
    ('D', 'Pending', 'Pending'),
    ('R', 'Retry', 'Retry');
