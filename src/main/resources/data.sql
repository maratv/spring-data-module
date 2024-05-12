INSERT INTO author(first_name, last_name, phone)
VALUES ('Лев', 'Толстой', '0001'),
       ('Александр', 'Пушкин', '0002');

INSERT INTO category(id, name)
VALUES (1, 'Роман'),
       (2, 'Стихи');

INSERT INTO book(title, language, active, category_id)
VALUES ('Война и мир', 'ru', true, 1),
       ('Лукоморье', 'ru', true, 2);

INSERT INTO authors_books(author_id, book_id)
VALUES (1, 1),
       (2, 2);