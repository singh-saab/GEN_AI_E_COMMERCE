// Register.js
import React from 'react'
import styled from 'styled-components'

const FormContainer = styled.div`
  max-width: 500px;
  margin: auto auto;
  padding: 20px;
  background-color: #f9f9f9;
  border-radius: 5px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
`

const FormTitle = styled.h2`
  text-align: center;
  margin-bottom: 20px;
`

const Form = styled.form`
  display: flex;
  flex-direction: column;
`

const FormLabel = styled.label`
  display: flex;
  justify-content: space-between;
  margin-bottom: 10px;
`

const FormInput = styled.input`
  padding: 10px;
  margin-bottom: 20px;
  border-radius: 5px;
  border: 1px solid #ccc;
`

const FormButton = styled.button`
  background-color: #333;
  color: #fff;
  padding: 10px 20px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
`

const FormButtonSecondary = styled.button`
  background-color: #ccc;
  color: #333;
  padding: 10px 20px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  margin-right: 10px;
`

const Register = () => {
  const handleSubmit = (e) => {
    e.preventDefault()
    // Handle registration logic here
  }

  return (
    <FormContainer>
      <FormTitle>Register</FormTitle>
      <Form onSubmit={handleSubmit}>
        <FormLabel>
          Name:
          <FormInput type='text' required />
        </FormLabel>
        <FormLabel>
          Email:
          <FormInput type='email' required />
        </FormLabel>
        <FormLabel>
          Password:
          <FormInput type='password' required />
        </FormLabel>
        <FormLabel>
          Confirm Password:
          <FormInput type='password' required />
        </FormLabel>
        <div style={{ display: 'flex', justifyContent: 'space-around' }}>
          <FormButton type='submit'>Register</FormButton>
          <FormButtonSecondary type='Reset'>Reset</FormButtonSecondary>
        </div>
      </Form>
    </FormContainer>
  )
}

export default Register
