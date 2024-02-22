// Product.js
import React from 'react'
import styled from 'styled-components'

const ProductCard = styled.div`
  width: 300px;
  height: 280px;
  border: 1px solid #ccc;
  border-radius: 5px;
  padding: 20px;
  padding-bottom:10px;
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
  bottom-margin:0px;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
`

const ProductPrice = styled.p`
  font-size: 16px;
  color: #888;
`
const AddToCartButton = styled.button`
  background-color: #333;
  width:95%;
  height:40px;
  color: #fff;
  padding: 0px 16px;
  border: none;
  border-radius: 5px;
  cursor: pointer;

`;

const Product = ({ title, price, image ,onAddToCart }) => {
  const handleAddToCart = () => {
    onAddToCart({ title, price, image });
  };

  return (
    <ProductCard>
      <div style={{display:'flex',justifyContent:'center'}}>
      <ProductImage src={image} alt={title} />

      </div>
      <ProductTitle>{title}</ProductTitle>
      <ProductPrice>${price}</ProductPrice>
      <div style={{Bottom:'0px' , display:'flex' , justifyContent:'center',paddingTop:''}}>
      <AddToCartButton  onClick={handleAddToCart}>Add to Cart</AddToCartButton>

      </div>
    </ProductCard>
  )
}

export default Product
