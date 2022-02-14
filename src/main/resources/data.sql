-- book
insert into "books" (id, name, description, page_number, publisher, cover, price)
values (1, 'name', 'description', 100, 'publisher', 'cover', 100);

insert into books (id, name, description, page_number, publisher, cover, price)
values (2, 'name', 'description', 100, 'publisher', 'cover', 100);

insert into books (id, name, description, page_number, publisher, cover, price)
values (3, 'name', 'description', 100, 'publisher', 'cover', 100);

insert into books (id, name, description, page_number, publisher, cover, price)
values (4, 'name', 'description', 100, 'publisher', 'cover', 100);


-- authors
insert into "authors" (id, name) values (1,'name1');
insert into "authors" (id, name) values (2,'name2');
insert into "authors" (id, name) values (3,'name3');
insert into "authors" (id, name) values (4,'name4');
-- genres
insert into "genres" (id, name) values (1,'genre1');
insert into "genres" (id, name) values (2,'genre2');
insert into "genres" (id, name) values (3,'genre3');

-- book_has_authors
insert into "book_has_authors"(book_id, author_id) values (1,1);
insert into "book_has_authors"(book_id, author_id) values (1,2);
insert into "book_has_authors"(book_id, author_id) values (2,1);
insert into "book_has_authors"(book_id, author_id) values (2,2);
insert into "book_has_authors"(book_id, author_id) values (2,3);
insert into "book_has_authors"(book_id, author_id) values (3,4);
insert into "book_has_authors"(book_id, author_id) values (4,1);

-- book_has_genres
insert into "book_has_genres"(book_id, genre_id) values(1,1);
insert into "book_has_genres"(book_id, genre_id) values(1,2);
insert into "book_has_genres"(book_id, genre_id) values(2,2);
insert into "book_has_genres"(book_id, genre_id) values(2,3);
insert into "book_has_genres"(book_id, genre_id) values(3,1);
insert into "book_has_genres"(book_id, genre_id) values(3,3);