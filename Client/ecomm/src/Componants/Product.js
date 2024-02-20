// Product.js
import React from 'react'
import styled from 'styled-components'

const ProductCard = styled.div`
  width: 300px;
  height: 300px;
  border: 1px solid #ccc;
  border-radius: 5px;
  padding: 20px;
`

const ProductImage = styled.img`
  width: 100px;
  height: 100px;
`

const ProductTitle = styled.h2`
  display: flex;
  flex-wrap: wrap;
  font-size: 18px;
  margin: 10px 0;
`

const ProductPrice = styled.p`
  font-size: 16px;
  color: #888;
`

const Product = ({ title, price, image }) => {
  console.log(image)
  return (
    <ProductCard>
      <ProductImage src={image} alt={title} />
      <ProductTitle>{title}</ProductTitle>
      <ProductPrice>${price}</ProductPrice>
    </ProductCard>
  )
}

export default Product
