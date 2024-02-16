// Header.js
import React from 'react'
import { Link } from 'react-router-dom'

function Header() {
  return (
    <nav className='navbar navbar-dark bg-dark'>
      <div className='container'>
        <Link className='navbar-brand' to='/'>
          My E-commerce Website
        </Link>
        <nav>
          <ul className='navbar-nav'>
            <li className='nav-item'>
              <Link className='nav-link' to='/'>
                Home
              </Link>
            </li>
            <li className='nav-item'>
              <Link className='nav-link' to='/products'>
                Products
              </Link>
            </li>
            <li className='nav-item'>
              <Link className='nav-link' to='/cart'>
                Cart
              </Link>
            </li>
          </ul>
        </nav>
      </div>
    </nav>
  )
}

export default Header
