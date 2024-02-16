// App.js
import React from 'react'
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'
import Home from './components/Home'
import ProductCatalog from './components/ProductCatalog'
import Cart from './components/Cart'
import Checkout from './components/Checkout'
import Header from './components/Header'
import NotFound from './components/NotFound' // Create a NotFound component

function App() {
  return (
    <Router>
      <div className='App'>
        <Header />
        <div className='container mt-3'>
          <Routes>
            <Route path='/' element={<Home />} />
            <Route path='/products' element={<ProductCatalog />} />
            <Route path='/cart' element={<Cart />} />
            <Route path='/checkout' element={<Checkout />} />
            <Route path='*' element={<NotFound />} />{' '}
            {/* Render NotFound for unmatched routes */}
          </Routes>
        </div>
      </div>
    </Router>
  )
}

export default App
