package cs3220.controller;

import cs3220.model.Item;
import cs3220.model.Store;
import cs3220.repository.ItemRepository;
import cs3220.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ShoppingListController {

    @Autowired
    private StoreRepository storeRepo;

    @Autowired
    private ItemRepository itemRepo;

    @GetMapping("/")
    public String viewShoppingList(Model model) {
        model.addAttribute("stores", storeRepo.findAll());
        return "shoppingList";
    }

    @GetMapping("/addItem")
    public String addItemForm(Model model) {
        model.addAttribute("stores", storeRepo.findAll());
        return "addItem";
    }

    @PostMapping("/addItem")
    public String addItem(@RequestParam String name, @RequestParam double price) {
        Store store = storeRepo.findAll().stream()
            .filter(s -> s.getName().equals("Super King"))
            .findFirst()
            .orElseGet(() -> {
                Store newStore = new Store();
                newStore.setName("Super King");
                return storeRepo.save(newStore);
            });

        Item item = new Item();
        item.setName(name);
        item.setPrice(price);
        item.setStore(store);
        itemRepo.save(item);

        return "redirect:/";
    }


    @PostMapping("/deleteItem/{itemId}")
    public String deleteItem(@PathVariable int itemId) {
        itemRepo.deleteById(itemId);
        return "redirect:/";
    }
}
