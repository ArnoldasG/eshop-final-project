import { Component, OnInit } from '@angular/core';
import {Product} from "./product";
import { ProductService } from '../service/product.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  products: Product[];

  constructor(private productService: ProductService) {
  }

  ngOnInit() {
    this.productService.findAll().subscribe(data => {
      this.products = data;
    });
  }
}
