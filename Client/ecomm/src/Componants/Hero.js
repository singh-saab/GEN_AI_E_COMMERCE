// Hero.js
import React from 'react'
import { Link } from 'react-router-dom'
import styled from 'styled-components'

const HeroContainer = styled.div`
  height: 100vh;
  background-image: url('../images/background.jpg');
  background-size: cover;
  background-position: center;
  display: flex;
  align-items: center;
  justify-content: center;
  color: #fff;
  text-align: center;
  image
`

const HeroContent = styled.div`
  max-width: 800px;
  padding: 20px;
`

const Title = styled.h1`
  font-size: 48px;
  margin-bottom: 20px;
`

const Subtitle = styled.p`
  font-size: 24px;
`

const Button = styled.button`
  background-color: #fff;
  color: #333;
  padding: 10px 20px;
  border: none;
  border-radius: 5px;
  text-decoration: none;
  font-size: 18px;
  cursor: pointer;
  transition: background-color 0.3s ease;

  &:hover {
    background-color: #ddd;
  }
`
const Hero = () => {
  const navigateToProducts = () => {
    // Navigate to the products page programmatically
    // For demonstration, you can use window.location.href
    window.location.href = '/products' // Update with your products page URL
  }
  return (
    <HeroContainer>
      <HeroContent>
        <Title>Welcome to Our Website</Title>
        <Subtitle>Your one-stop destination for all your needs</Subtitle>
        <Button onClick={navigateToProducts}>Explore Products</Button>
      </HeroContent>
    </HeroContainer>
  )
}

export default Hero
