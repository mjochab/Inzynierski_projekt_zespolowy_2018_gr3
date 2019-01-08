package patron.mains.guis.widgets.menu.controllerExtend;


import patron.mains.guis.widgets.menu.builders.RootMenuTreeViewBuilder;
import com.appscharles.libs.fxer.abstracts.AbstractViewControllerFxExtend;
import com.appscharles.libs.fxer.factories.MenuItemNodeFactory;
import com.appscharles.libs.fxer.factories.MenuTreeCellFactory;
import com.appscharles.libs.fxer.models.MenuItemTreeView;
import javafx.fxml.FXML;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;

/**
 * The type 20 tree view controller extend.
 */
public class _20_TreeViewControllerExtend extends AbstractViewControllerFxExtend {

    /**
     * The Container pane.
     */
    protected AnchorPane containerPane;
    /**
     * The Tree view.
     */
    @FXML
    protected TreeView<MenuItemTreeView> treeView;

    /**
     * Instantiates a new 20 tree view controller extend.
     */
    protected _20_TreeViewControllerExtend() {
        this.addOnInitializeWithSneakyThrow(() -> {
            this.treeView.setRoot(RootMenuTreeViewBuilder.create(this.containerPane, this.resourceBundle).build());
            this.treeView.setCellFactory(tc -> new MenuTreeCellFactory(new MenuItemNodeFactory()));
        });
    }
}
