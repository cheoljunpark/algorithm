SELECT
    id,
    fish_name,
    a.length AS length
FROM
    fish_info AS a INNER JOIN fish_name_info AS b
    ON a.fish_type = b.fish_type
WHERE 
    a.fish_type IN (
        SELECT fish_type
        FROM fish_info
        GROUP BY fish_type
        HAVING length = MAX(length)
    )
ORDER BY
    id ASC;