SELECT
    a.item_id,
    item_name
FROM
    item_info AS a join item_tree AS b
    ON a.item_id = b.item_id
WHERE
    parent_item_id IS NULL
ORDER BY
    item_id ASC;