// App.js
import React, { useState, useEffect } from 'react'
import Header from './Componants/Header'
import Footer from './Componants/Footer'
import Register from './Componants/Register'
import Login from './Componants/Login'
import Products from './Componants/Products'
import Hero from './Componants/Hero'
import { Route, Routes } from 'react-router-dom'

const App = () => {
  return (
    <div>
      <Header />
      <Routes>
        <Route path='/' element={<Hero />} />
        <Route path='/products' element={<Products />} />
        <Route path='/Register' element={<Register />} />
        <Route path='/login' element={<Login />} />
      </Routes>

      <Footer />
    </div>
  )
}

export default App
