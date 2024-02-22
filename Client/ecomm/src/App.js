// App.js
import React, { useState, useEffect } from 'react'
import Header from './Componants/Header'
import Footer from './Componants/Footer'
import Register from './Componants/Register'
import Login from './Componants/Login'
import Products from './Componants/Products'
import Hero from './Componants/Hero'
import { Route, Routes } from 'react-router-dom'
import Cart from './Componants/Cart'

const App = () => {
  const [cartItems, setCartItems] = useState([]);

  const handleAddToCart = (product) => {
    setCartItems([...cartItems, product]);
  };
  return (
    <div>
      <Header />
      <Routes>
        <Route path='/' element={<Hero />} />
        <Route path='/products' element={<Products handleAddToCart={handleAddToCart}/>} />
        <Route path='/Register' element={<Register />} />
        <Route path='/login' element={<Login />} />
        <Route path='/cart' element={<Cart items={cartItems} />} />
      </Routes>

      <Footer />
    </div>
  )
}

export default App
