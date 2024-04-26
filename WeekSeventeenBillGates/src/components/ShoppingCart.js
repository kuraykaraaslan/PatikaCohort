import React from "react";

function shoppingCart() {
  return (
    <div className="shopping_container">
      <div className="title">Your Shopping Spree</div>
      <div className="shopping-items">
        <div className="shopping-item">
          <div className="title">Big Mac</div>
          <div className="count">x 5</div>
        </div>
      </div>
    </div>
  );
}

export default shoppingCart;
