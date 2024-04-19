package com.targetindia.model

import lombok.Data

@Data
class Customer {
    var id: Int? = null
    var name: String? = null
    var email: String? = null
    var city: String? = null
}