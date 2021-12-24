SELECT 
	goods.id AS goods_id,
	goods.barcode AS barcode,
	goods.name AS "name",
	remnants_price.remnant_shop_1 AS remnant_shop_1,
	remnants_price.price_shop_1 AS price_shop_1,
	remnants_price.remnant_shop_2 AS remnant_shop_2,
	remnants_price.price_shop_2 AS price_shop_2,
	remnants_price.remnant_shop_3 AS remnant_shop_3,
	remnants_price.price_shop_3 AS price_shop_3
FROM goods AS goods
LEFT JOIN (
	SELECT 
		goods_id AS goods_id,	
		MAX(
			CASE  
				WHEN shop_id = 1 
				THEN remnant
				ELSE NULL
			END
		) AS remnant_shop_1,
		MAX(
			CASE  
				WHEN shop_id = 1 
				THEN price
				ELSE NULL
			END
		) AS price_shop_1,	
		MAX(
			CASE  
				WHEN shop_id = 2 
				THEN remnant
				ELSE NULL
			END
		) AS remnant_shop_2,
		MAX(
			CASE  
				WHEN shop_id = 2 
				THEN price
				ELSE NULL
			END
		) AS price_shop_2,

		MAX(
			CASE  
				WHEN shop_id = 3 
				THEN remnant
				ELSE NULL
			END
		) AS remnant_shop_3,
		MAX(
			CASE  
				WHEN shop_id = 3 
				THEN price
				ELSE NULL
			END
		) AS price_shop_3
	FROM goods_remnants_price_for_shop  
	GROUP BY goods_id
)  AS remnants_price ON remnants_price.goods_id = goods.id 
ORDER BY 
	goods.id,
	goods.barcode,
	goods.name