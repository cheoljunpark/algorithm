SELECT  
    a.book_id,
    b.author_name,
    DATE_FORMAT(a.published_date, '%Y-%m-%d') AS published_date
FROM book a JOIN author b
    ON a.author_id = b.author_id
WHERE
    a.category = '경제'
ORDER BY
    a.published_date ASC;