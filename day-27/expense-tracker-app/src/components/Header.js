import React, { Component } from 'react';

class Header extends Component {
  render() {
    return (
      <>
        <div className='navbar navbar-expand-lg bg-primary' data-bs-theme="dark">
          <div className='container'>
            <h1 className='navbar-brand'>
              <i className='bi bi-piggy-bank me-3'></i>
              <span>Expense Tracker</span>
            </h1>
          </div>
        </div>
      </>
    );
  }
}

export default Header;