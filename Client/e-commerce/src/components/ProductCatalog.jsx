// ProductCatalog.js
import React, { useState, useEffect } from 'react'
import axios from 'axios'

function ProductCatalog() {
  const [products, setProducts] = useState([])

  useEffect(() => {
    // Simulate fetching products from an API
    const fetchProducts = async () => {
      try {
        // You can replace this with an actual API call
        // For demonstration, we are using a dummy data array
        const response = await axios.get('/api/products')
        setProducts(response.data)
      } catch (error) {
        console.error('Error fetching products:', error)
      }
    }

    fetchProducts()
  }, [])

  // Dummy product list if API call fails or unavailable
  const dummyProducts = [
    {
      id: 1,
      name: 'Product 1',
      description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.',
      amount: 19.99,
      imageUrl: 'https://via.placeholder.com/150',
    },
    {
      id: 2,
      name: 'Product 2',
      description:
        'Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.',
      amount: 29.99,
      imageUrl: 'https://via.placeholder.com/150',
    },
    {
      id: 3,
      name: 'Product 3',
      description:
        'Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.',
      amount: 39.99,
      imageUrl: 'https://via.placeholder.com/150',
    },
  ]

  // Use products if available, otherwise use dummy product list
  const productList = products.length ? products : dummyProducts

  return (
    <div className='row'>
      {productList.map((product) => (
        <div key={product.id} className='col-md-4 mb-4'>
          <div className='card'>
            <img
              src={product.imageUrl}
              className='card-img-top'
              alt={product.name}
            />
            <div className='card-body'>
              <h5 className='card-title'>{product.name}</h5>
              <p className='card-text'>{product.description}</p>
              <p className='card-text'>${product.amount}</p>
              {/* Add to cart button */}
            </div>
          </div>
        </div>
      ))}
    </div>
  )
}

export default ProductCatalog
