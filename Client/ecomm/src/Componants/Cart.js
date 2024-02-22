// Cart.js
import React from 'react';
import styled from 'styled-components';

const CartContainer = styled.div`
  border: 1px solid #ccc;
  border-radius: 5px;
  padding: 20px;
  margin-bottom: 20px;
`;

const CartTitle = styled.h2`
  font-size: 20px;
  margin-bottom: 10px;
`;

const CartItem = styled.div`
  margin-bottom: 10px;
`;

const Cart = ({ items }) => {
  return (
    <CartContainer>
      <CartTitle>Shopping Cart</CartTitle>
      {items.map((item, index) => (
        <CartItem key={index}>
          <strong>{item.title}</strong> - ${item.price}
        </CartItem>
      ))}
    </CartContainer>
  );
};

export default Cart;
