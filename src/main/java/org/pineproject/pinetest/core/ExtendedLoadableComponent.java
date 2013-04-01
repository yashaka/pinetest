package org.pineproject.pinetest.core;

import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public abstract class ExtendedLoadableComponent<T extends ExtendedLoadableComponent<T>>
        implements HaveExpectedElements {

    @SuppressWarnings("unchecked")
    public T get() {
        try {
            isLoaded();
            return (T) this;
        } catch (Error e) {
            initAndLoad();
        }

        isLoaded();

        return (T) this;
    }

//    /*
//     * This method is used to call PageFactory.initElements(...)
//     * or any of its alternatives (HtmlElementLoader.populate(...))
//     *   before calling load() method that will actually load a page.
//     * Calling PageFactory initialization in the 'load' context of get()
//     *   results in the fact you can't create implement some elements' containers
//     *   on the page as separate pages. In short, you can't consider as a page anything
//     *   that was already loaded in context of other page.
//     *   The recommended way to make an abstractions of such logical groups of elements
//     *   is to implement them as real element containers and use them as fields
//     *   inside 'parent' page.
//     */
    private void initAndLoad() {
        HtmlElementLoader.populate(this, driver);
        load();
    }

    protected abstract void load();

    protected abstract void isLoaded() throws Error;

    public ExtendedLoadableComponent(WebDriver driver) {
        this.driver = driver;
    }

    protected WebDriver driver;

}
