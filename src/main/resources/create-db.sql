-- Insert de autores
INSERT INTO public.autores(
    data_de_criacao, descricao, email, nome)
VALUES (to_date('10/01/2020','dd/mm/yyyy'), 'Autor de romance', 'cesar_romano@gmail.com', 'Cesar Romano');
INSERT INTO public.autores(
    data_de_criacao, descricao, email, nome)
VALUES (to_date('05/04/2022','dd/mm/yyyy'), 'Autor de romance', 'bruno_marinho@gmail.com', 'Bruno Marinho');
INSERT INTO public.autores(
    data_de_criacao, descricao, email, nome)
VALUES (to_date('05/02/2022','dd/mm/yyyy'), 'Autor de drama', 'maria_antonia@gmail.com', 'Maria Antonia Coutinho');
INSERT INTO public.autores(
    data_de_criacao, descricao, email, nome)
VALUES (to_date('10/05/2015','dd/mm/yyyy'), 'Autor de Livro Infantil', 'julio_gomes@terra.com', 'Julio Gomes Terra');
INSERT INTO public.autores(
    data_de_criacao, descricao, email, nome)
VALUES (to_date('25/05/2012','dd/mm/yyyy'), 'Autor de quadrinhos', 'ricardo_quaresma@hotmail.com', 'Ricardo Quaresma');

-- O insert de categoria
INSERT INTO public.categoria(
     nome)
VALUES ('Romance');
INSERT INTO public.categoria(
    nome)
VALUES ('Comédia');
INSERT INTO public.categoria(
    nome)
VALUES ('Quadrinhos');
INSERT INTO public.categoria(
    nome)
VALUES ('Drama');

-- Insert de livros
INSERT INTO public.livro(
    data_estreia, isbn, nome, paginas, preco, resumo, sumario, autor_id, categoria_id)
VALUES (to_date('05/02/2022','dd/mm/yyyy'), '125333444527', 'O romance de castilho', 340, 40.9, 'Um livro sobre romance espanhol', 'sem sumario', 2, 1);
INSERT INTO public.livro(
    data_estreia, isbn, nome, paginas, preco, resumo, sumario, autor_id, categoria_id)
VALUES (to_date('12/05/2020','dd/mm/yyyy'), '055348444427', 'A comedia de todos', 222, 51.9, 'Um livro sobre uma comedia de todos', 'sem sumario', 1, 2);
INSERT INTO public.livro(
    data_estreia, isbn, nome, paginas, preco, resumo, sumario, autor_id, categoria_id)
VALUES (to_date('12/11/2019','dd/mm/yyyy'), '185148478427', 'O drama de harry', 125, 45.5, 'Um livro sobre o drama de harry', 'sem sumario', 4, 4);