import React, { Component } from 'react';
import CurrencyDropDown from './CurrencyDropDown';
import axios from 'axios';
import ConvertedAmount from './ConvertedAmount';
import '../App.css';


class Main extends Component{

    constructor(props){
        super(props)
        this.state={
            haveCurrency:'EUR',
            wantCurrency:'EUR',
            amount:'',
            convertedAmount:''
        }
        
    }

    changeHaveCurrencyValue = (e) => {this.setState({haveCurrency: e.target.value});}
    changeWantCurrencyValue = (e) => {this.setState({wantCurrency: e.target.value});}
    changeAmount = (e) => {console.log(e.target.value);this.setState({amount: e.target.value});}
    nullAmount = (e) => {this.setState({convertedAmount: ''})}
    
    handleSubmit=(e)=>{
        e.preventDefault();
        axios.post(`http://localhost:8080/`, {
            fromCurrency:this.state.haveCurrency,
	        toCurrency:this.state.wantCurrency,
	        amount:this.state.amount
        })
        .then(
            response => {
                this.setState({convertedAmount: response.data});
            })
    }

    render(){
        return(
            <div>
                <form onSubmit={this.handleSubmit}>
                    <div className="flex-container" onClick={this.nullAmount}>
                        <CurrencyDropDown currencyState="Have"
                        onChangeValue={this.changeHaveCurrencyValue} 
                        
                        />
                        <CurrencyDropDown currencyState="Want"
                        onChangeValue={this.changeWantCurrencyValue} />
                        
                    </div>
                    <div className="item-center"> 
                        <div class="input-group my-3 col-9">
                            <div class="input-group-prepend">
                                <span class="input-group-text">Amount to convert: </span>
                            </div>
                            <input type="text" aria-label="amount" class="form-control"
                            onClick={this.nullAmount}
                            onChange={this.changeAmount}
                            value={this.state.amount}/>
                            
                        </div>
                    </div>

                    <div className="item-center">
                        <button className="btn btn-light" type="submit">Convert</button>
                    </div>
                    
                    
                </form>
                <div>
                    <ConvertedAmount 
                    initAmount={this.state.amount}
                    initCurrency={this.state.haveCurrency}
                    convertedAmount={this.state.convertedAmount}
                    convertedCurrency={this.state.wantCurrency}
                    />
                </div>
            </div>
        )
    }
}

export default Main;