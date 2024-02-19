import React from 'react';
import ProductItem from './ProductItem';

const ProductCatalog = () => {
  // Dummy product data
  const products = [
    { id: 1, name: 'Product 1', description: 'Description 1', amount: 10 },
    { id: 2, name: 'Product 2', description: 'Description 2', amount: 20 },
    { id: 3, name: 'Product 3', description: 'Description 3', amount: 30 }
  ];

  return (
    <div className="container">
      <h2>Product Catalog</h2>
      <div className="row">
        {products.map(product => (
          <div className="col-md-4 mb-3" key={product.id}>
            <ProductItem product={product} />
          </div>
        ))}
      </div>
    </div>
  );
};

export default ProductCatalog;
