import React, { useState, useEffect } from 'react'
import Product from './Product'
const Products = () => {
  const [products, setProducts] = useState([])

  useEffect(() => {
    fetch('https://fakestoreapi.com/products')
      .then((response) => response.json())
      .then((data) => setProducts(data))
      .catch((error) => console.error('Error fetching products:', error))
  }, [])
  return (
    <div
      style={{
        display: 'flex',
        flexWrap: 'wrap',
        gap: '5px',
        justifyContent: 'center',
      }}
    >
      {products.map((product) => (
        <Product
          price={product.price}
          title={product.title}
          image={product.image}
        />
      ))}
    </div>
  )
}

export default Products
