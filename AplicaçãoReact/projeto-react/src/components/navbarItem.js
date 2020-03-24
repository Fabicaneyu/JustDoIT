import React from 'react'

function NavbarItem(prop) {

    return(

        <li  className="nav-item">
                <img src={prop.image} className={prop.classN}/>
              <a onClick={prop.action} className="nav-link" href={prop.href}>{prop.label}</a>
        </li>

    )

}

export default NavbarItem