USE app_db;

INSERT INTO `user` (`userid`, `name`, `sureName`) VALUES
(1, 'Alex', 'Star'),
(2, 'Piter', 'Pan'),
(3, 'Dan', 'Force'),
(4, 'Mary', 'Topaz'),
(5, 'Liza', 'Grand');

INSERT INTO `account` (`accountid`, `account`, `userid`, `amount`) VALUES
(1, 1, 1, 2312.0),
(2, 2, 1, 4212.0),
(3, 1, 2, 311.0),
(4, 1, 3, 12443.0),
(5, 1, 4, 23198.0),
(5, 1, 5, 872319.0);