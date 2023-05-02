SELECT a.title, a.board_id, b.reply_id, b.writer_id, b.contents, DATE_FORMAT(b.created_date,'%Y-%m-%d') AS created_date
FROM used_goods_board AS a 
JOIN used_goods_reply AS b 
    ON a.board_id = b.board_id
WHERE a.created_date LIKE '2022-10%'
ORDER BY b.created_date ASC, a.title ASC;
