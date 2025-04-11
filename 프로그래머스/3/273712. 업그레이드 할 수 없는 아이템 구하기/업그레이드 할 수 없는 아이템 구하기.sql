select i.item_id, item_name, i.rarity
from item_info i 
where not exists(
    select *
    from item_tree t
    where t.parent_item_id = i.item_id
    )
order by i.item_id desc