import React from 'react';
import '../App.css';

function CurrencyDropDown(props){


    return(
        <div>
            <label for="currency">Currency I {props.currencyState}: </label>
            <br />
            <select name="currency" id="currency" onChange={props.onChangeValue} className="drop-down-css">
                <option value="EUR">Euro (EUR)</option>
                <option value="AED">UAE dirham (AED)</option>
                <option value="AFN">Afghani (AFN)</option>
                <option value="ALL">Albanian lek (ALL)</option>
                <option value="AMD">Armenian dram (AMD)</option>
                <option value="ARS">Argentine peso (ARS)</option>
                <option value="AUD">Australian dollar (AUD)</option>
                <option value="AZN">Azerbaijan manat (AZN)</option>
                <option value="BAM">Convertible marks (BAM)</option>
                <option value="BDT">Bangladeshi taka (BDT)</option>
                <option value="BGN">Bulgarian lev (BGN)</option>
                <option value="BHD">Bahraini dinar (BHD)</option>
                <option value="BYN">Belarussian ruble (BYN)</option>
                <option value="BOB">Bolivian boliviano (BOB)</option>
                <option value="BRL">Brazilian real (BRL)</option>
                <option value="CAD">Canadian dollar (CAD)</option>
                <option value="CHF">Swiss franc (CHF)</option>
                <option value="CYP">Cyprus pound (CYP)</option>
                <option value="CNY">Chinese yuan renminbi (CNY)</option>
                <option value="COP">Colombian peso (COP)</option>
                <option value="CZK">Czech koruna (CZK)</option>
                <option value="DJF">Djibouti franc (DJF)</option>
                <option value="DKK">Danish krone (DKK)</option>
                <option value="DZD">Algerian dinar (DZD)</option>
                <option value="EGP">Egyptian pound (EGP)</option>
                <option value="ETB">Ethiopian birr (ETB)</option>
                <option value="GBP">Pound sterling (GBP)</option>
                <option value="GEL">Georgian lari (GEL)</option>
                <option value="GHS">Ghana cedi (GHS)</option>
                <option value="GNF">Guinean franc (GNF)</option>
                <option value="HKD">Hong Kong dollar (HKD)</option>
                <option value="HRK">Croatian kuna (HRK)</option>
                <option value="HUF">Hungarian forint (HUF)</option>
                <option value="IDR">Indonesian rupiah (IDR)</option>
                <option value="ILS">Israeli new shekel (ILS)</option>
                <option value="INR">Indian rupee (INR)</option>
                <option value="IQD">Iraqi dinar (IQD)</option>
                <option value="IRR">ranian rial (IRR)</option>
                <option value="ISK">Iceland krona (ISK)</option>
                <option value="JOD">Jordanian dinar (JOD)</option>
                <option value="JPY">Japanese yen (JPY)</option>
                <option value="KES">Kenyan shilling (KES)</option>
                <option value="KGS">Kyrghyzstan som (KGS)</option>
                <option value="KRW">South Korean won (KRW)</option>
                <option value="KWD">Kuwaiti dinar (KWD)</option>
                <option value="KZT">Kazakhstan tenge (KZT)</option>
                <option value="LBP">Lebanese pound (LBP)</option>
                <option value="LKR">Sri Lanka rupee (LKR)</option>
                <option value="LYD">Libyan dinar (LYD)</option>
                <option value="MAD">Moroccan dirham (MAD)</option>
                <option value="MDL">Moldovan leu (MDL)</option>
                <option value="MGA">Malagasy ariary (MGA)</option>
                <option value="MKD">Macedonian denar (MKD)</option>
                <option value="MNT">Mongolian tugrik (MNT)</option>
                <option value="MUR">Mauritius rupee (MUR)</option>
                <option value="MXN">Mexican peso (MXN)</option>
                <option value="MYR">Malaysian ringgit (MYR)</option>
                <option value="MZN">Mozambique metical (MZN)</option>
                <option value="NGN">Naira (NGN)</option>
                <option value="NOK">Norwegian krone (NOK)</option>
                <option value="NZD">New Zealand dollar (NZD)</option>
                <option value="PAB">Panamanian balboa (PAB)</option>
                <option value="PEN">Peruvian sol (PEN)</option>
                <option value="PHP">Philippine peso (PHP)</option>
                <option value="PKR">Pakistan rupee (PKR)</option>
                <option value="PLN">Polish zloty (PLN)</option>
                <option value="QAR">Qatari rial (QAR)</option>
                <option value="RON">Romanian leu (RON)</option>
                <option value="RSD">Serbian dinar (RSD)</option>
                <option value="RUB">Russian ruble (RUB)</option>
                <option value="SAR">Saudi riyal (SAR)</option>
                <option value="SEK">Swedish krona (SEK)</option>
                <option value="SGD">Singapore dollar (SGD)</option>
                <option value="SYP">Syrian pound (SYP)</option>
                <option value="THB">Thai baht (THB)</option>
                <option value="TJS">Tajikistan somoni (TJS)</option>
                <option value="TMT">Turkmenistan new manat (TMT)</option>
                <option value="TND">Tunisian dinar (TND)</option>
                <option value="TRY">Turkish lira (TRY)</option>
                <option value="TWD">Taiwan new dollar (TWD)</option>
                <option value="TZS">Tanzanian shilling (TZS)</option>
                <option value="UAH">Ukrainian hryvnia (UAH)</option>
                <option value="USD">US dollar (USD)</option>
                <option value="UYU">Peso Uruguayo (UYU)</option>
                <option value="UZS">Uzbekistan sum (UZS)</option>
                <option value="VES">Venezuelan bolivar soberano (VES)</option>
                <option value="VND">Vietnamese dong (VND)</option>
                <option value="XAF">CFA franc BEAC (XAF)</option>
                <option value="XOF">CFA franc BCEAO (XOF)</option>
                <option value="YER">Yemeni rial (YER)</option>
                <option value="ZAR">South African rand (ZAR)</option>
            </select>
        </div>
    )

}
export default CurrencyDropDown;