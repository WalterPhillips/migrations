package org.apache.ibatis.migration.commands;

import org.apache.ibatis.migration.MigrationException;
import org.apache.ibatis.migration.options.SelectedOptions;
import org.apache.ibatis.migration.options.SelectedPaths;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class NewCommandTest {
  private SelectedOptions newSelectedOption;
  private SelectedPaths selectedPaths;

  @Before
  public void setup() {
    selectedPaths = new SelectedPaths();
    selectedPaths.setBasePath(new File("src/test/java/org/apache/ibatis/migration/commands"));

    newSelectedOption = new SelectedOptions();
    newSelectedOption.setCommand("New");
    newSelectedOption.setPaths(selectedPaths);
  }

  @Test
  (expected = MigrationException.class)
  public void testThrowsExceptionWhenDescriptionIsNotSupplied() {
    NewCommand newCommand = new NewCommand(newSelectedOption);
    newCommand.execute("");
  }

  @Test
  public void testSpacesInDescriptionIsReplacedWithUnderscores() {
    NewCommand newCommand = new NewCommand(newSelectedOption);
    newCommand.execute("must be underscores instead of spaces between words");
  }
}