import "./style.css";

const Purchase = () => {
  return (
    <div id="purchase" className="container">
      <div className="sectionHeader">
        <h3>PURCHASE FROM US</h3>
        <p>
          Lorem ipsum dolor sit amet consectetur, adipisicing elit. Doloribus,
          magni fugiat ex suscipit necessitatibus sint.
        </p>
      </div>

      <div className="purchaseContainer">
        <div className="purchaseCard">
          <img src="./images/purchase1.jpg" alt="Kettlebell / 5 kg" />
          <h4 className="purchaseItemName">Kettlebell / 5 kg</h4>
          <h4 className="purchaseItemPrice">
            <span>89,99</span>$ / 59,99$
          </h4>
          <div className="cart">
            <a href="">Add to Cart</a>
          </div>
        </div>
        <div className="purchaseCard">
          <img src="./images/purchase2.jpg" alt="Treadmill" />
          <h4 className="purchaseItemName">Treadmill</h4>
          <h4 className="purchaseItemPrice">
            <span>899,99</span>$ / 599,99$
          </h4>
          <div className="cart">
            <a href="">Add to Cart</a>
          </div>
        </div>
        <div className="purchaseCard">
          <img src="./images/purchase3.jpg" alt="Adjustable Dumbell" />
          <h4 className="purchaseItemName">Adjustable Dumbell</h4>
          <h4 className="purchaseItemPrice">
            <span>89,99</span>$ / 59,99$
          </h4>
          <div className="cart">
            <a href="">Add to Cart</a>
          </div>
        </div>
        <div className="purchaseCard">
          <img src="./images/purchase4.jpg" alt="Kettlebell / 3 kg" />
          <h4 className="purchaseItemName">Kettlebell / 3 kg</h4>
          <h4 className="purchaseItemPrice">
            <span>89,99</span>$ / 59,99$
          </h4>
          <div className="cart">
            <a href="">Add to Cart</a>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Purchase;
