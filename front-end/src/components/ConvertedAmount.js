import React from 'react';


function ConvertedAmount(props){
    if(props.convertedAmount===''){
        return(
            <div></div>
            // <div className="item-center my-3">
            //     <div className="drop-down-css empty-response"></div>
            // </div>
            
        )    
    }else{
        return(
            <div className="item-center my-3">
                <div className="drop-down-css p-3 ">
                    {props.initAmount} {props.initCurrency} converts to {props.convertedAmount} {props.convertedCurrency}
                </div>
            </div>
            
        )
    }
}
export default ConvertedAmount;
