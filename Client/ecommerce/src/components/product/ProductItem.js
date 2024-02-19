import React from 'react';

const ProductItem = ({ product }) => {
  return (
    <div className="card">
      <img src="..." className="card-img-top" alt="Product" />
      <div className="card-body">
        <h5 className="card-title">{product.name}</h5>
        <p className="card-text">{product.description}</p>
        <p className="card-text">Price: ${product.amount}</p>
        {/* Add button to add to cart */}
      </div>
    </div>
  );
};

export default ProductItem;
